package BookStore;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class AddBook {


    static void addBook() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł: ");
        String tytul = scanner.nextLine();

        System.out.println("Podaj  ISBN: ");
        String isbnNumer = scanner.nextLine();
        if (isbnNumer.length() != 10 || !StringUtils.isNumeric(isbnNumer)) {
            System.out.println("ISBN musi zawierać 10 cyfr");
            isbnNumer = scanner.nextLine();
        }
        System.out.println("Podaj rok wydania");
        String rokWydania = scanner.nextLine();
        if (rokWydania.length() != 4 || !StringUtils.isNumeric(rokWydania)) {
            System.out.println("Rok wydania powinien mieć format yyyy");
            rokWydania = scanner.nextLine();
        }
        Book nowaKsiazka = new Book(tytul, rokWydania, isbnNumer);
        BookList.getBookList().add(nowaKsiazka);

    }
}


