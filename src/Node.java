public class Node implements Movie {
    private Node prev; // reference to the previous node in the list private Nodenext; // reference
    private String title;
    private Node next;
    private int accessCount;

    public Node(String e, Node p, Node n) {
        title = e;
        prev = p;
        next = n;
        accessCount = 0;
    }

    public String element() throws IllegalStateException {
        if (this.next == null) // convention for defunct node
            throw new IllegalStateException("Position no longer valid");
        return title;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setElement(String e) {
        this.title = e;
    }

    public void setPrev(Node p) {
        this.prev = p;
    }

    public void setNext(Node n) {
        this.next = n;
    }
    public void incrementAccessCount(){
        this.accessCount++;
    }

    public int accessCount(){
        return this.accessCount;
    }
}