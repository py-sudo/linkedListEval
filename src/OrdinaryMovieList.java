/*
implements MovieList interface
*/


/**
 * Implementation of a positional list stored as a doubly linked list.
 */
public class OrdinaryMovieList implements MovieList {

    private Node header; // header sentinel
    private Node trailer; // trailer sentinel
    private int size = 0; // number of elements in the list

    /**
     * Constructs a new empty list.
     */
    public OrdinaryMovieList() {
        header = new Node(null, null, null); // create header
        trailer = new Node(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    private Node validate(Movie p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        Node node = (Node) p; // safe cast
        if (node.getNext() == null) // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /**
     * Returns the number of elements in the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    private Movie addBetween(String e, Node pred, Node succ) {
        Node newest = new Node(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    /**
     * Inserts element e at the back of the linked list and returns its new
     * Position.
     */
    public Movie insert(String e) {
        return addBetween(e, trailer.getPrev(), trailer); // just before the trailer
    }

    public String remove(Movie p) throws IllegalArgumentException {
        Node node = validate(p);
        Node predecessor = node.getPrev();
        Node successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        String e = node.element();
        node.setElement(null); // help with garbage collection
        node.setNext(null); // and convention for defunct node
        node.setPrev(null);
        return e;
    }


    public boolean searchMovie(String title) {
        // search for movie
        Node n = header;
        while ((n = n.getNext()) != trailer) {
            if (n.element().equals(title)) {
                n.incrementAccessCount();
                return true;
            }
        }
        return false;
    }

    public void printAccessedTime() {
        System.out.println();
//        System.out.println("---------------printing access times for list 1--------------");
        System.out.println("Ordinary Movie List Access");
        System.out.println("--------------------------");
        Node n = header;
        while ((n = n.getNext()) != trailer) {
            System.out.println(n.element() + ": " + n.accessCount() + " times");
        }
        System.out.println();
    }


}





