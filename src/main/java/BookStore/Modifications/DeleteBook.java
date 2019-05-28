package BookStore.Modifications;


import BookStore.Book;
import BookStore.BookList;
import BookStore.Warnings;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeleteBook {


    public static void deleteBook() {

        Scanner scanner = new Scanner(System.in);
        String onlyTitle = BookList.getBookList().stream().map(book -> book.getTitle()).collect(Collectors.joining("; "));
        System.out.println("Podaj tytuł ksiązki do usunięcia: " + onlyTitle);
        String tytul = scanner.nextLine();
        Warnings.titleWarning(scanner, tytul);
        int indeks = 0;
        for (Book book : BookList.getBookList()) {
            if (book.getTitle().equals(tytul)) {
                indeks = BookList.getBookList().indexOf(book);
            }
        }
        BookList.getBookList().remove(indeks);
    }

}
