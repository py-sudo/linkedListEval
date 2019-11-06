/* Besides a method element() which returns (String) movieTitle, 
the interface of this ADT should include another method 
public int accessCount(), which returns the number of times that a Movie object (i.e., its movieTitle) has been accessed.
*/
public interface Movie {
      public String element() throws IllegalStateException;
      public int accessCount(); 

}