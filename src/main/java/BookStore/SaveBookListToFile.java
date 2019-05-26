package BookStore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static BookStore.BookStore.bookList;

public class SaveBookListToFile {

    static void saveFile() throws FileNotFoundException {

        String path = "E:/JAVA/Programowanie2/src/main/resources/SaveMyListToFile.csv";
       // File bookListFile = new File(path);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)))) {

         for (Book line : bookList) {
             String lineToWrite = line.getTytul() + "; "+line.getRokWydania()+"; "+ line.getIsbnNumer();
                bw.write(lineToWrite+ ":"+"\n");
            }
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
