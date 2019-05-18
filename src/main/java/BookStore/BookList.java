package BookStore;

import java.util.ArrayList;
import java.util.List;

// Singleton

public class BookList {

    private static final BookList BOOK_LIST = new BookList();

     private static List<Book> bookList = new ArrayList<>();

    public static List<Book> getBookList() {
        return bookList;
    }


}
