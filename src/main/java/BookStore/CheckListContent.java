package BookStore;

import java.util.List;

public class CheckListContent {

    public  boolean checkIfBookIsInList(List<Book> books, String tytul) {
        return books.stream().map(book -> book.getTitle()).anyMatch(s -> s.equals(tytul));
    }
}
