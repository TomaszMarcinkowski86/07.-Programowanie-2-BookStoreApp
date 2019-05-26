package BookStore;

import java.util.List;

public class IsbnYearTitleBookPrintStrategy implements BookPrintStrategy {

    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println
                    (book.getIsbnNumer() + " " +
                            book.getRokWydania() + " " +
                            book.getTytul()
                    );
        }

    }
}
