package BookStore.display.format.strategy;

import BookStore.Book;

import java.util.List;

public interface BookPrintStrategy {

    void print(List<Book> bookList);
}

