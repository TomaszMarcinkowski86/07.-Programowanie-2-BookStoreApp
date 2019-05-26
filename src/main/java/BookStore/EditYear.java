package BookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EditYear {

    static void editYear() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł ksiązki do edycji roku wydania: " + BookList.getBookList().stream()
                .map(book -> book.getTytul()).collect(Collectors.joining(", ")));
        String tytul = scanner.nextLine();
        Warnings warnings=new Warnings();
        tytul = warnings.titleWarning(scanner, tytul);
        int newYear;
        for (Book book : BookList.getBookList()) {
            if (book.getTytul().equals(tytul)) {
                System.out.println("Podaj nowy rok wydania");
                newYear = scanner.nextInt();
                while (newYear < 1000 || newYear > 2020) {
                    System.out.println("Rok wydania nie mieści się w zakresie 1000-2020");
                    newYear = scanner.nextInt();
                }
                book.setRokWydania(newYear);
                System.out.println();
            }
        }
    }

//    private static String titleWarning(Scanner scanner, String tytul) {
//        CheckListContent checkListContent= new CheckListContent();
//        boolean check=checkListContent.checkIfBookIsInList(BookList.getBookList(), tytul);
//        while (!check) {
//            System.out.println("Nieprawidłowy tytuł!!");
//            tytul = scanner.nextLine();
//        }
//        return tytul;
//    }


}

