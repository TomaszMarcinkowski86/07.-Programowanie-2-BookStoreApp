package BookStore;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookFunction {

    // W pętli sprawdzam czy podany isbn jest równy z isbn Booka jak jest to go zwracam
    public Book findISBN(String isbn, List<Book> booklist) {

        for (Book book : booklist) {
            if (book.getIsbnNumer().equals(isbn)) {
                return book;
            }
        }
        return null;

    }

    //Jeśli lista ma więcej niż 2 elementy to zwracam sublistę z 2 ostatnimi
    public List<Book> reurnTwoLast(List<Book> booklist) {
        if (booklist.size() > 2)
            return booklist.subList(booklist.size() - 2, booklist.size());
        else
            return booklist;
    }

    //Użysłem Comparatora do posortowania listy i potem zwracam 1-szy obiekt z listy
    private void comparatorMethod(List<Book> bookList) {

        Comparator<Book> BookYearComparator = new Comparator<Book>() {

            public int compare(Book year1, Book year2) {
                String bookYear1 = year1.getRokWydania().toUpperCase();
                String bookYear2 = year2.getRokWydania().toUpperCase();

                //ascending order
                return bookYear1.compareTo(bookYear2);

                //descending order
                //return bookYear2.compareTo(bookYear1);
            }
        };
        Collections.sort(bookList, BookYearComparator);
    }

    // wywołanie comparatora i zwracam 1-szy element
    public Book returnErliestBook(List<Book> bookList) {
        comparatorMethod(bookList);
        return bookList.get(0);
    }

    // wywołanie comparatora i zwracam ostatni element
    public Book returnLatestBook(List<Book> bookList) {
        comparatorMethod(bookList);
        return bookList.get(bookList.size() - 1);
    }
//Stream zmienia mi to na mapę intów i sumuje. To co w mapie Integer.praseInt bo mam stringa
    public int returnSumPublishmentYear(List<Book> bookList) {
       return bookList.stream().mapToInt(Book-> Integer.parseInt(Book.getRokWydania())).sum();
    }

}

