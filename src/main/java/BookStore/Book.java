package BookStore;

import java.util.List;

public class Book {
    private String title;
    private long isbnNumber;
    private int yearOfPublishment;
    private int bookID;
    private List<Author> author;
    private  Category category;

    public Book(String title, int yearOfPublishment,long isbnNumber) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.yearOfPublishment = yearOfPublishment;
    }

    public Book(String title, Long isbnNumber, int yearOfPublishment, int bookID, List<Author> author, Category category) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.yearOfPublishment = yearOfPublishment;
        this.bookID = bookID;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public long getIsbnNumber() {
        return isbnNumber;
    }

    public int getYearOfPublishment() {
        return yearOfPublishment;
    }

    public int getBookID() {
        return bookID;
    }

    public void setYearOfPublishment(int yearOfPublishment) {
        this.yearOfPublishment = yearOfPublishment;
    }

  @Override
    public String toString() {
        return title +" " + yearOfPublishment +" " + isbnNumber;
    }


}
