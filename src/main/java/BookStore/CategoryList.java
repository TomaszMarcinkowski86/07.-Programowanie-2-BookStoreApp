package BookStore;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {

    private static final CategoryList CATEGORY_LIST = new CategoryList();

    private static List<Category> categoryList = new ArrayList<>();

    public static List<Category> getCategoryList() {
        return categoryList;
    }
}
