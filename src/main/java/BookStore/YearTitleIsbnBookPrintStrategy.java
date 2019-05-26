package BookStore;

import java.util.List;

public class YearTitleIsbnBookPrintStrategy implements BookPrintStrategy{

    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println
                    (book.getRokWydania() + " " +
                            book.getTytul() + " " +
                            book.getIsbnNumer());
        }

    }
}

