package BookStore.load.save.file;

import BookStore.Author;
import BookStore.AuthorList;

import java.io.*;
import java.util.List;

public class LoadAuthorsFile {


   public static List<Author> loadFile()  {
        String path = "E:/JAVA/Programowanie2/src/main/resources/authors.csv";
        File authorsListFile = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(authorsListFile))) {

            String linia = br.readLine();
            while (linia != null) {

                String[] slowo = linia.split(";");
                Author author = new Author(Integer.parseInt(slowo[0]), slowo[1], Integer.parseInt(slowo[2]));
                AuthorList.getAuthorList().add(author);
                linia = br.readLine();
            }
        } catch (IOException e) {

        }
        return AuthorList.getAuthorList();
    }
}