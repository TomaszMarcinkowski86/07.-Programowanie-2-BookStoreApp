package BookStore;

import java.util.Scanner;

public class Warnings {

    public static  String titleWarning(Scanner scanner, String tytul) {
        CheckListContent checkListContent= new CheckListContent();
        boolean check=checkListContent.checkIfBookIsInList(BookList.getBookList(), tytul);
        while (!check) {
            System.out.println("Nieprawidłowy tytuł!!");
            tytul = scanner.nextLine();
        }
        return tytul;
    }

}
