package BookStore.display.format.strategy;

import BookStore.Author;
import BookStore.Book;

import java.util.List;

public interface AuthorPrintStrategy {

  void print(List<Author> authorsList);
}
