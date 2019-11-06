import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MovieListComparator {
    /*  class variables  */
    public final static String[] movieCollection = {
            "Casablanca",
            "Cast Away",
            "Forrest Gump",
            "Ghost",
            "Gladiator",
            "Midnight Cowboy",
            "One Flew Over the Cuckoo's Nest",
            "The Dead Poet Society",
            "The Godfather",
            "Tootsie"
    };
    OrdinaryMovieList list1;
    SelfOrganizedMovieList list2;
    String[] accessedMovies = new String[80000000];

    /*  constructor  */
    public MovieListComparator() {

    }

    /*  store movieCollection in an empty movieList */
    public void storeInList(MovieList list) {
        for (int i = 0; i < movieCollection.length; i++) {
            list.insert(movieCollection[i]);
        }
    }

    ;

    /*  from a given file, read a list of previously accessed movies
       (one title per line), and store the list in accessedMovies array
    */
    public int readAccessedMovies(String filename) {
        try {
            int index = 0;
            Scanner scanner = new Scanner(new File("./" + filename));
            while (scanner.hasNextLine()) {
                String movie = scanner.nextLine();
               // for (int i = 0; i < 799; i++) {
                    accessedMovies[index] = movie;
                    index++;
               // }
            }
            scanner.close();
            return index;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
            // throw FileNotFoundException();
        }

    }


    // MovieAccessYear2001.dat
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieListComparator mc = new MovieListComparator();
        mc.list1 = new OrdinaryMovieList();
        mc.list2 = new SelfOrganizedMovieList();
        mc.storeInList(mc.list1);
        mc.storeInList(mc.list2);

        System.out.print("Enter a filename with a previous access record: ");
        String fileName = sc.nextLine();
        int numberOfTestTitles = mc.readAccessedMovies(fileName);
        System.out.println();
        System.out.println("Analyzing...");
        System.out.println();


        SearchTimer st1 = new SearchTimer(mc.list1);
        SearchTimer st2 = new SearchTimer(mc.list2);
        long runTimeOrdinaryList = st1.measure(mc.accessedMovies, numberOfTestTitles);
        long runTimeSelfOrganizedList = st2.measure(mc.accessedMovies, numberOfTestTitles);
        System.out.println("Ordinary list takes: " + runTimeOrdinaryList + "ms");
        System.out.println("Self Organizing list takes: " + runTimeSelfOrganizedList + "ms");

        if (runTimeOrdinaryList == runTimeSelfOrganizedList)
            System.out.println("Self Organized list and Ordinary List has same performance for this test");
        else if (runTimeOrdinaryList > runTimeSelfOrganizedList)
            System.out.println("Self Organized list out performed OrdinaryList by : " + (runTimeOrdinaryList - runTimeSelfOrganizedList) + " ms");
        else {
            System.out.println("OrdinaryList out performed Self Organized list by : " + (runTimeSelfOrganizedList - runTimeOrdinaryList) + " ms");
            System.out.println("Hint: Try with bigger list,you will see different result");
        }


        mc.list1.printAccessedTime();
        mc.list2.printAccessedTime();


    }
}
