public interface MovieList {
    public int size();
    public boolean isEmpty();
    public boolean searchMovie(String title);
    public String remove(Movie p);
    public Movie insert(String title);
}