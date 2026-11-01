/* This program defines the book objects to function as the assignment nececitates. 
This program utilizes 'this' keyword since the parameters have the same names. The 
fields are also encapsulated and use accessors to return the values */

public class Book {
    private String title;
    private int totalCopies;
    private int checkedOut;

    public Book(String title, int totalCopies, int checkedOut) {
        if(title == null) {
            throw new NullPointerException();
        }
        if(checkedOut < 0 || checkedOut > totalCopies) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.totalCopies = totalCopies;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return this.title;
    }

    public int getAvailable() {
        return this.totalCopies-this.checkedOut;
    }

    public String toString() {
        return title + ": " + getAvailable() + " of " + totalCopies + " copies available";
    }
}