package BookStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadFile extends Book{

    public LoadFile(String tytul, String isbnNumer, String rokWydania) {
        super(tytul, isbnNumer, rokWydania);
    }

    static List<Book> loadFile() throws IOException {
        String path = "D:/JAVA/Programowanie2/src/sources/books.csv";
        File bookListFile = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(bookListFile));
        List<Book> bookList = new ArrayList<>();

        String linia;
        while
        ((linia = br.readLine()) != null) {
            String[] slowo = linia.split(";");
            Book ksiazka =new Book(slowo[0],slowo[1],slowo[2]); //tworzymy książkę do niej wrzucamy to co po splicie wyszlo
            bookList.add(ksiazka);
        }
        return bookList;
    }
}