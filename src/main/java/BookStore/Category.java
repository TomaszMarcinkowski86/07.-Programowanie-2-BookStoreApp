package BookStore;

public class Category {

    private int categoryID;
    private String categoryName;
    private int categoryPriority;

    public Category(int categoryID, String categoryName, int categoryPriority) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryPriority = categoryPriority;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryPriority() {
        return categoryPriority;
    }
}
