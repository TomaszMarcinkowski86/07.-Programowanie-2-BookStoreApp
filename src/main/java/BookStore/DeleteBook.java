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
        Warnings warnings=new Warnings();
        tytul = warnings.titleWarning(scanner, tytul);
        int indeks = 0;
        for (Book book : BookList.getBookList()) {
            if (book.getTytul().equals(tytul)) {
                indeks = BookList.getBookList().indexOf(book);
            }
        }
        BookList.getBookList().remove(indeks);
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
