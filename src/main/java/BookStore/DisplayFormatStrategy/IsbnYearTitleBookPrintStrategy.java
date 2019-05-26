package BookStore.DisplayFormatStrategy;

import BookStore.Book;

import java.util.List;

public class IsbnYearTitleBookPrintStrategy implements BookPrintStrategy {

    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println
                    (book.getIsbnNumber() + " " +
                            book.yearOfPublishment() + " " +
                            book.getTitle()
                    );
        }

    }
}
