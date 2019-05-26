package BookStore;

import java.io.*;
import java.util.List;

public class LoadAuthorsFile {


    static List<Author> loadFile() throws FileNotFoundException {
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
            e.printStackTrace();

        }
        return AuthorList.getAuthorList();
    }
}