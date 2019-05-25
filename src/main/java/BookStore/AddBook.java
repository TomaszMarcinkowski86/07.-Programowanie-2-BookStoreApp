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

        while (isbnNumer.length() != 10 || !StringUtils.isNumeric(isbnNumer)) {
            System.out.println("ISBN musi zawierać 10 cyfr");
            isbnNumer = scanner.nextLine();
        }
        System.out.println("Podaj rok wydania");
        int rokWydania = scanner.nextInt();
        while(rokWydania < 1000 || rokWydania > 2020) {
            System.out.println("Rok wydania nie mieści się w zakresie 1000-2020");
            rokWydania = scanner.nextInt();
        }
        Book nowaKsiazka = new Book(tytul, rokWydania, isbnNumer);
        BookList.getBookList().add(nowaKsiazka);
    }


}




