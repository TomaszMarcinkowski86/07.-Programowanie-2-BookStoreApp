package BookStore;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class BooksFunction {

    // W pętli sprawdzam czy podany isbn jest równy z isbn Booka jak jest to go zwracam
    public Book findISBN(long isbn, List<Book> booklist) {

        for (Book book : booklist) {
            if (book.getIsbnNumber()==(isbn)) {
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

            public int compare(Book ksiazka1, Book ksiazka2) {

                //ascending order
                int bookYear1 = ksiazka1.getYearOfPublishment();
                int bookYear2 = ksiazka2.getYearOfPublishment();
                return Integer.compare(bookYear1, bookYear2);
                //descending order
                //return bookYear2.compareTo(bookYear1);
            }
        };
//
        bookList.sort(BookYearComparator);
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
        return bookList.stream()
                .mapToInt(Book -> Book.getYearOfPublishment())
                .sum();
    }

    //Stream filtruje ksiązki których data większa od 2007. wcześniej zamieniam na integera a na koniec zliczam
    public static long returnNumberBooksAfter2007(List<Book> bookList) {
        return bookList.stream()
                .filter(ksiazka -> ksiazka.getYearOfPublishment() > 2007)
                .count();
    }

    public boolean allAfter2000(List<Book> bookList) {
        return bookList.stream()
                .allMatch(ksiazka -> ksiazka.getYearOfPublishment() > 2000);
    }

    public Double averageDate(List<Book> bookList) {
        return bookList.stream()
                .mapToInt(ksiazka -> ksiazka.getYearOfPublishment())
                .average()
                .getAsDouble();

    }

    public boolean returnInfoIfAnyBookBefore2003(List<Book> bookList) {
        return bookList.stream()
                .filter(ksiazka -> ksiazka.getYearOfPublishment() < 2003)
                .count() > 1;
    }

    public List<Book> returnBookStartCAndAfter2007(List<Book> bookList) {
        return bookList.stream().filter(ksiazka -> ksiazka.getYearOfPublishment() > 2007)
                .filter(ksiazka -> ksiazka.getTitle().startsWith("C"))
                .collect(Collectors.toList());
    }

    public List<Book> returnBookIfYearDivide2(List<Book> bookList) {
        return bookList.stream()
                .filter(ksiazka -> ksiazka.getYearOfPublishment() % 2 == 0)
                .collect(Collectors.toList());
    }

    public Map<String, Book> returnMap(List<Book> bookList) {
        return bookList.stream()
                .collect(Collectors.toMap(x -> String.valueOf(x.getIsbnNumber()), x -> x));
    }

    public static List<Book> sortBookDateLast(List<Book> bookList) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getYearOfPublishment))
                .collect(Collectors.toList());

    }

    public static List<Book> sortBookDateFirst(List<Book> bookList) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getYearOfPublishment).reversed())
                .collect(Collectors.toList());
    }

    public List<List<Book>> splitListTo3Lists(List<Book> bookList) {
        List<List<Book>> lists = Lists.partition(bookList, 2);
        return lists;
    }
//Pogrupuj książki po roku wydania. Metoda powinna zwrócić Map<Integer, List<Book>>
// gdzie kluczem jest rok wydania a wartością lista książek wydana w tym roku. (*)

    public Map<Integer, List<Book>> bookYearSorted(List<Book> booklist) {
        return booklist.stream().collect(Collectors.groupingBy(year -> (year.getYearOfPublishment())));
    }

    //    Podziel książki na te wydane po 2009 roku i pozostałe. Metoda powinna zwrócić Map<Boolean, List<Book>>
    //    gdzie kluczem jest boolean oznaczający czy została wydana po 2009 a wartością będą listy książek. (*)
    public Map<Boolean, List<Book>> bookAfter2009YearSorted(List<Book> booklist) {
        return booklist.stream().collect(Collectors.groupingBy(year -> (year.getYearOfPublishment() > 2009)));
    }
}

