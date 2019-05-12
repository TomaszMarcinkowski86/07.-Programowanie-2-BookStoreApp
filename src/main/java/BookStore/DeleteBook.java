package BookStore;

import java.util.Scanner;

public class DeleteBook {

    static void deleteBook(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł ksiązki do usunięcia: " + BookList.getBookList());
        String tytul = scanner.nextLine();
        int indeks = tytul.indexOf(tytul);
        BookList.getBookList().remove(indeks);
        
    }
}
