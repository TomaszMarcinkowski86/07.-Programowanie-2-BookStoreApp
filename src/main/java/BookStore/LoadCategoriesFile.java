package BookStore;

import java.io.*;
import java.util.List;

public class LoadCategoriesFile {

    static List<Category> loadFile() throws FileNotFoundException {
        String path = "E:/JAVA/Programowanie2/src/main/resources/categories.csv";
        File categoriesListFile = new File(path);

        try (BufferedReader br = new BufferedReader(new FileReader(categoriesListFile))) {

            String linia = br.readLine();
            while (linia != null) {

                String[] slowo = linia.split(";");
                Category category = new Category(Integer.parseInt(slowo[0]), slowo[1], Integer.parseInt(slowo[2]));
                CategoryList.getCategoryList().add(category);
                linia = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return CategoryList.getCategoryList();
    }
}
