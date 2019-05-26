package BookStore;

import BookStore.DisplayFormatStrategy.BookPrintStrategy;
import BookStore.DisplayFormatStrategy.IsbnYearTitleBookPrintStrategy;
import BookStore.DisplayFormatStrategy.TitleYearIsbnBookPrintStrategy;
import BookStore.DisplayFormatStrategy.YearTitleIsbnBookPrintStrategy;
import BookStore.Modifications.DeleteBook;
import BookStore.Modifications.EditYear;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookStore {

    static List<Book> bookList = new ArrayList<>();

    static {
        try {
            bookList = LoadBookFile.loadFile();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

    public static void main(String[] args) throws IOException {


        System.out.println("1. Wyświetl listę książek");
        System.out.println("2. Dodaj książkę");
        System.out.println("3. Usuń książekę po nazwie");
        System.out.println("4. Edytuj rok wydania");
        System.out.println("5. Zapisz listę książek do pliku csv");
        System.out.println("6. Sortuj po roku wydania rosnąco");
        System.out.println("7. Sortuj po roku wydania malejąco");
        System.out.println("8. Wyświetl książki wydane po 2007");
        System.out.println("9. Wyjdź");
        System.out.println("10. FORMAT: Tytuł, Rok, ISBN ");
        System.out.println("11. FORMAT: Rok, Tytuł, ISBN ");
        System.out.println("12. FORMAT: ISBN, Rok, Tytuł ");


        Scanner scanner = new Scanner(System.in);
        int choose;
        BookPrintStrategy bookPrintStrategy = new TitleYearIsbnBookPrintStrategy();
        do {
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Lista dostępnych książek");
                    bookPrintStrategy.print(bookList);
                    break;
                case 2:
                    AddBook.addBook();
                    System.out.println("Dodałeś nową książkę: ");
                    whatNext("Co chcesz zrobić dalej? ");
                    break;
                case 3:
                    DeleteBook.deleteBook();
                    System.out.println("Co chcesz zrobić dalej? ");
                    break;
                case 4:
                    EditYear.editYear();
                    System.out.println("Zmieniono rok wydania książki");
                    break;
                case 5:
                    SaveBookListToFile.saveFile();
                    System.out.println("Zapisano do pliku w: ");
                    break;
                case 6:
                    System.out.println("Posortowano po dacie rosnąco");
                    bookPrintStrategy.print(BooksFunction.sortBookDateLast(bookList));
                    break;
                case 7:
                    System.out.println("Posortowano po dacie malejąco");
                    bookPrintStrategy.print(BooksFunction.sortBookDateFirst(bookList));
                    break;
                case 8:
                    System.out.println("Liczba Ksiażek wydanych po 2007:" + " "
                            + BooksFunction.returnNumberBooksAfter2007(bookList));
                    break;
                case 9:
                    System.out.println("Zapraszamy ponownie");
                    break;
                case 10:
                    bookPrintStrategy = new TitleYearIsbnBookPrintStrategy();
                    System.out.println("Lista będzie wyświetlana w Formacie: Tytuł, Rok, ISBN ");
                    break;
                case 11:
                    bookPrintStrategy = new YearTitleIsbnBookPrintStrategy();
                    System.out.println("Lista będzie w Formacie: Rok, Tytuł, ISBN  ");
                    break;
                case 12:
                    bookPrintStrategy = new IsbnYearTitleBookPrintStrategy();
                    System.out.println("Lista będzie wyświetlana w Formacie: ISBN, Rok, Tytuł");
                    break;
                default:
                    System.out.println("Wybrałeś nieprawidłową komendę");
            }
        } while (choose != 9);

    }

    private static void whatNext(String s) {
        System.out.println(s);
    }

}
