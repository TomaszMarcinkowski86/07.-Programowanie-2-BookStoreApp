package BookStore;

import java.util.Scanner;
import java.util.stream.Collectors;

public class EditYear {

    static void editYear(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł ksiązki do edycji roku wydania: " + BookList.getBookList().stream()
                .map(book -> book.getTytul()).collect(Collectors.joining(", ")));
        String tytul = scanner.nextLine();
        int indeks = tytul.indexOf(tytul);
        BookList.getBookList();

    }
}
