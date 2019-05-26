package BookStore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadBookFile {


    static List<Book> loadFile() throws FileNotFoundException {
        String path = "E:/JAVA/Programowanie2/src/main/resources/books.csv";
        File bookListFile = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(bookListFile))) {

            String linia = br.readLine();
            while (linia != null) {

                String[] slowo = linia.split(";");
                Book ksiazka = new Book(slowo[0], Integer.parseInt(slowo[2]), slowo[1]);
                BookList.getBookList().add(ksiazka);
                linia = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return BookList.getBookList();
    }
}