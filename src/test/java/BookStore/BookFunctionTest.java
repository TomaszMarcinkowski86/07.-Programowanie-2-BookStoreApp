package BookStore;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.hamcrest.collection.IsMapContaining;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookFunctionTest {

    List<Book> bookList = new ArrayList<Book>();
    BookFunction bookFunction = new BookFunction();

    //to będzie wywoływane przed każdym testem
    @Before
    public void mojaListaTestowa() {

        bookList.add(new Book("tytul1", 2001, "1111111111"));
        bookList.add(new Book("tytul2", 2002, "2222222222"));
        bookList.add(new Book("tytul3", 2003, "3333333333"));
        bookList.add(new Book("Cytul4", 2010, "4444444444"));
        bookList.add(new Book("tytul5", 2005, "5555555555"));
        bookList.add(new Book("tytul6", 2000, "6666666666"));
    }

    @Test
    @DisplayName("Tytuł po ISBN")
    public void checkReturnBookIsbn() {

        Book book = bookFunction.findISBN("6666666666", bookList);
        Assert.assertEquals("tytul6", book.getTytul());
    }

    @Test
    @DisplayName("Ostatnie dwie")
    public void reurnTwoLast() {

        //AsertJ biblioteki do obsługi kolekcji
        assertThat(bookFunction.reurnTwoLast(bookList)).contains(bookList.get(4)).contains(bookList.get(5));
    }

    @Test
    @DisplayName("Najwcześniej wydana")
    public void returErliestYear() {
        Book book = bookFunction.returnErliestBook(bookList);
        Assert.assertEquals("tytul6", book.getTytul());

    }

    @Test
    @DisplayName("Najpóźniej wydana")
    public void returLatestYear() {
        Book book = bookFunction.returnLatestBook(bookList);
        Assert.assertEquals("tytul4", book.getTytul());
    }

    @Test
    @DisplayName("Suma lat wydania")
    public void returnSumPublishmentYear() {
        int suma = bookFunction.returnSumPublishmentYear(bookList);
        Assert.assertEquals(12021, suma);

    }

    @Test
    public void returnNumberBooksAfter2007() {
        long liczbaKsiązekPo2007 = bookFunction.returnNumberBooksAfter2007(bookList);
        Assert.assertEquals(1, liczbaKsiązekPo2007);
    }

    @Test
    public void allAfter2000() {
        boolean allAfter2000 = bookFunction.allAfter2000(bookList);
        Assert.assertFalse(allAfter2000);
    }

    @Test
    @DisplayName("Suma lat wydania")
    public void averageDate() {
        double average = bookFunction.averageDate(bookList);
        Assert.assertEquals(2003.5, average, 0.01);

    }

    @Test
    @DisplayName("czy jakaś książka wydana przed 2003")
    public void returnInfoIfAnyBookBefore2003() {
        boolean anyBefore2003 = bookFunction.returnInfoIfAnyBookBefore2003(bookList);
        Assert.assertTrue(anyBefore2003);
    }

    @Test
    public void returnBookStartCAndAfter2007() {
        List<Book> listAfterSort = bookFunction.returnBookStartCAndAfter2007(bookList);
        Assert.assertEquals("Cytul4", listAfterSort.get(0).getTytul());
    }

    @Test
    public void returnBookIfYearDivide2() {
        List<Book> listAfterSort2 = bookFunction.returnBookIfYearDivide2(bookList);
        Assert.assertEquals("tytul2", listAfterSort2.get(0).getTytul());
        Assert.assertEquals("Cytul4", listAfterSort2.get(1).getTytul());
        Assert.assertEquals("tytul6", listAfterSort2.get(2).getTytul());
    }

    @Test
    public void returnMap() {
        Map<String, Book> map = bookFunction.returnMap(bookList);
        Assert.assertThat(map, IsMapContaining.hasEntry("1111111111", bookList.get(0)));
//        Assertions.assertThat(map).containsEntry("1111111111", bookList.get(0)))

    }

    @Test
    public void sortBookDateLast() {
        List<Book> sortList = bookFunction.sortBookDateLast(bookList);
        Assert.assertEquals("tytul6", sortList.get(0).getTytul());
    }

    @Test
    public void sortBookDateFirst() {
        List<Book> sortList = bookFunction.sortBookDateFirst(bookList);
        Assert.assertEquals("tytul6", sortList.get(5).getTytul());
    }

}



