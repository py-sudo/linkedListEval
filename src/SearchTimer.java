
public class SearchTimer {
    /*  class variables  */ 
    MovieList ML;
    long executionTime;

    /*  constructor  */
    public SearchTimer(MovieList L) {
        ML = L;
    }

    /*  perform searches for testTitles on ML,
        and return the overall execution time in milliseconds
    */
    public long measure(String[] testTitles, int numberOfTestTitles) {
        long start = System.currentTimeMillis();
            for (int i = 0; i < numberOfTestTitles; i++) {
                ML.searchMovie(testTitles[i]);
            }

        executionTime = System.currentTimeMillis() - start;
        return executionTime;

    }   
}
