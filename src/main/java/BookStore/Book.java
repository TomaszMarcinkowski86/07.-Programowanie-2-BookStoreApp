package BookStore;

public class Book {
    private String title;
    private String isbnNumber;
    private int yearOfPublishment;
    private  String authorName;

    public Book(String title,int yearOfPublishment, String isbnNumber) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.yearOfPublishment = yearOfPublishment;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setYearOfPublishment(int yearOfPublishment) {
       this.yearOfPublishment=yearOfPublishment;
    }

    public int yearOfPublishment() {
        return yearOfPublishment;
    }
    @Override
    public String toString() {
        return title +" " + yearOfPublishment +" " + isbnNumber;
    }


}
