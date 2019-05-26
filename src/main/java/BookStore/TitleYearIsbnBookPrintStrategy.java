package BookStore;

import java.util.List;

public class TitleYearIsbnBookPrintStrategy implements BookPrintStrategy{


        @Override
        public void print(List<Book> bookList) {
            for (Book book : bookList) {
                System.out.println
                        (book.getTytul() + " " +
                                book.getRokWydania() + " " +
                                book.getIsbnNumer());
            }

        }
    }

