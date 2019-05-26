package BookStore;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class AddBook {


    static void addBook() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();

        System.out.println("Podaj  ISBN: ");
        Long isbnNumber = scanner.nextLong();

        while (isbnNumber.toString().length() != 10 ) {
            System.out.println("ISBN musi zawierać 10 cyfr");
            isbnNumber = scanner.nextLong();
        }
        System.out.println("Podaj rok wydania");
        int yearOfPublishment = scanner.nextInt();
        while (yearOfPublishment < 1000 || yearOfPublishment > 2020) {
            System.out.println("Rok wydania nie mieści się w zakresie 1000-2020");
            yearOfPublishment = scanner.nextInt();
        }

        Book newBook = new Book(title, yearOfPublishment, isbnNumber);
        BookList.getBookList().add(newBook);
    }


}




