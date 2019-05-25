package BookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeleteBook {

    static void deleteBook() {

        Scanner scanner = new Scanner(System.in);
        String tylkoTytul = BookList.getBookList().stream().map(book -> book.getTytul()).collect(Collectors.joining("; "));
        System.out.println("Podaj tytuł ksiązki do usunięcia: " + tylkoTytul);
        String tytul = scanner.nextLine();
        while (!checkIfBookIsInList(BookList.getBookList(), tytul)) {
            System.out.println("Nieprawidłowy tytuł!!");
            tytul = scanner.nextLine();
        }
        int indeks = 0;
        for (Book book : BookList.getBookList()) {
            if (book.getTytul().equals(tytul)) {
                indeks = BookList.getBookList().indexOf(book);
            }
        }
        BookList.getBookList().remove(indeks);
    }

    private static boolean checkIfBookIsInList(List<Book> books, String tytul) {
        return books.stream().map(book -> book.getTytul()).anyMatch(s -> s.equals(tytul));
    }

}
