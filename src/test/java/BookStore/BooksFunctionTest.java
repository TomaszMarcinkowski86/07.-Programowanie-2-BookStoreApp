package BookStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.hamcrest.collection.IsMapContaining;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class BooksFunctionTest {

    List<Book> bookList = new ArrayList<Book>();
    BooksFunction booksFunction = new BooksFunction();

    //to będzie wywoływane przed każdym testem
    @Before
    public void mojaListaTestowa() {

        bookList.add(new Book("tytul1", 2001, "1111111111"));
        bookList.add(new Book("tytul2", 2002, "2222222222"));
        bookList.add(new Book("tytul3", 2003, "3333333333"));
        bookList.add(new Book("Cytul4", 2010, "4444444444"));
        bookList.add(new Book("tytul5", 2000, "5555555555"));
        bookList.add(new Book("tytul6", 2000, "6666666666"));
    }

    @Test
    @DisplayName("Tytuł po ISBN")
    public void checkReturnBookIsbn() {

        Book book = booksFunction.findISBN("6666666666", bookList);
        Assert.assertEquals("tytul6", book.getTitle());
    }

    @Test
    @DisplayName("Ostatnie dwie")
    public void reurnTwoLast() {

        //AsertJ biblioteki do obsługi kolekcji
        assertThat(booksFunction.reurnTwoLast(bookList)).contains(bookList.get(4)).contains(bookList.get(5));
    }

    @Test
    @DisplayName("Najwcześniej wydana")
    public void returErliestYear() {
        Book book = booksFunction.returnErliestBook(bookList);
        Assert.assertEquals("tytul5", book.getTitle());

    }

    @Test
    @DisplayName("Najpóźniej wydana")
    public void returLatestYear() {
        Book book = booksFunction.returnLatestBook(bookList);
        Assert.assertEquals("Cytul4", book.getTitle());
    }

    @Test
    @DisplayName("Suma lat wydania")
    public void returnSumPublishmentYear() {
        int suma = booksFunction.returnSumPublishmentYear(bookList);
        Assert.assertEquals(12016, suma);

    }

    @Test
    public void returnNumberBooksAfter2007() {
        long liczbaKsiązekPo2007 = booksFunction.returnNumberBooksAfter2007(bookList);
        Assert.assertEquals(1, liczbaKsiązekPo2007);
    }

    @Test
    public void allAfter2000() {
        boolean allAfter2000 = booksFunction.allAfter2000(bookList);
        Assert.assertFalse(allAfter2000);
    }

    @Test
    @DisplayName("Suma lat wydania")
    public void averageDate() {
        double average = booksFunction.averageDate(bookList);
        Assert.assertEquals(2002.66, average, 0.01);

    }

    @Test
    @DisplayName("czy jakaś książka wydana przed 2003")
    public void returnInfoIfAnyBookBefore2003() {
        boolean anyBefore2003 = booksFunction.returnInfoIfAnyBookBefore2003(bookList);
        Assert.assertTrue(anyBefore2003);
    }

    @Test
    public void returnBookStartCAndAfter2007() {
        List<Book> listAfterSort = booksFunction.returnBookStartCAndAfter2007(bookList);
        Assert.assertEquals("Cytul4", listAfterSort.get(0).getTitle());
    }

    @Test
    public void returnBookIfYearDivide2() {
        List<Book> listAfterSort2 = booksFunction.returnBookIfYearDivide2(bookList);
        Assert.assertEquals("tytul2", listAfterSort2.get(0).getTitle());
        Assert.assertEquals("Cytul4", listAfterSort2.get(1).getTitle());
        Assert.assertEquals("tytul5", listAfterSort2.get(2).getTitle());
        Assert.assertEquals("tytul6", listAfterSort2.get(3).getTitle());
    }

    @Test
    public void returnMap() {
        Map<String, Book> map = booksFunction.returnMap(bookList);
        Assert.assertThat(map, IsMapContaining.hasEntry("1111111111", bookList.get(0)));
//        Assertions.assertThat(map).containsEntry("1111111111", bookList.get(0)))

    }

    @Test
    public void sortBookDateLast() {
        List<Book> sortList = booksFunction.sortBookDateLast(bookList);
        Assert.assertEquals("tytul5", sortList.get(0).getTitle());
        Assert.assertEquals("tytul6", sortList.get(1).getTitle());
        Assert.assertEquals("Cytul4", sortList.get(5).getTitle());
    }

    @Test
    public void sortBookDateFirst() {
        List<Book> sortList = booksFunction.sortBookDateFirst(bookList);
        Assert.assertEquals("tytul6", sortList.get(5).getTitle());
    }

    @Test
    public void splitListTo3Lists() {
        List<List<Book>> lists = booksFunction.splitListTo3Lists(bookList);
        for (List<Book> sublist : lists) ;
    }

    @Test
    public void bookYearSorted() {
        Map<Integer, List<Book>> mapOfBookSortedYear = booksFunction.bookYearSorted(bookList);
        List<Book> list2000 = new ArrayList<>();
        list2000.add(bookList.get(4));
        list2000.add(bookList.get(5));
        List<Book> list2001 = new ArrayList<>();
        list2001.add(bookList.get(0));
        List<Book> list2002 = new ArrayList<>();
        list2002.add(bookList.get(1));
        List<Book> list2003 = new ArrayList<>();
        list2003.add(bookList.get(2));
        List<Book> list2010 = new ArrayList<>();
        list2010.add(bookList.get(3));
        Map<Integer, List<Book>> mapToTest = new HashMap<>();
        mapToTest.put(2000, list2000);
        mapToTest.put(2001, list2001);
        mapToTest.put(2002, list2002);
        mapToTest.put(2003, list2003);
        mapToTest.put(2010, list2010);
        Assert.assertEquals(mapToTest, mapOfBookSortedYear);

    }

    @Test
    public void bookafter2009YearSorted() {
        Map<Boolean, List<Book>> mapOfBookSortedAfter2009Year = booksFunction.bookAfter2009YearSorted(bookList);
        List<Book> listFalse = new ArrayList<>();
        listFalse.add(bookList.get(0));
        listFalse.add(bookList.get(1));
        listFalse.add(bookList.get(2));
        listFalse.add(bookList.get(4));
        listFalse.add(bookList.get(5));
        List<Book> listTrue = new ArrayList<>();
        listTrue.add(bookList.get(3));
        Map<Boolean, List<Book>> mapToTest = new HashMap<>();
        mapToTest.put(false, listFalse);
        mapToTest.put(true, listTrue);
        Assert.assertEquals(mapToTest, mapOfBookSortedAfter2009Year);

    }
}





