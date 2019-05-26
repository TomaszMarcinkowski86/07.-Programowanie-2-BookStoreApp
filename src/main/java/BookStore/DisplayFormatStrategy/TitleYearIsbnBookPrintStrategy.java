package BookStore.DisplayFormatStrategy;

import BookStore.Book;

import java.util.List;

public class TitleYearIsbnBookPrintStrategy implements BookPrintStrategy {

    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println
                    (book.getTitle() + " " +
                            book.getYearOfPublishment() + " " +
                            book.getIsbnNumber());
        }

    }
}

