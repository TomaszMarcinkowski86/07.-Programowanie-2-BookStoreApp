package BookStore.Modifications;


import BookStore.Book;
import BookStore.BookList;
import BookStore.Warnings;

import java.util.Scanner;
import java.util.stream.Collectors;

public class EditYear {

    public static void editYear() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł ksiązki do edycji roku wydania: " + BookList.getBookList().stream()
                .map(book -> book.getTitle()).collect(Collectors.joining(", ")));
        String tytul = scanner.nextLine();


        int newYear;
        for (Book book : BookList.getBookList()) {
            if (book.getTitle().equals(tytul)) {
                System.out.println("Podaj nowy rok wydania");
                newYear = scanner.nextInt();
                while (newYear < 1000 || newYear > 2020) {
                    System.out.println("Rok wydania nie mieści się w zakresie 1000-2020");
                    newYear = scanner.nextInt();
                }
                book.setYearOfPublishment(newYear);
                System.out.println();
            }
        }
    }
}

