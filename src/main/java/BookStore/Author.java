package BookStore;

public class Author {

    private String authorName;
    private int authorAge;
    private int authorID;

    public String getAuthorName() {
        return authorName;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public int getAuthorID() {
        return authorID;
    }

    public Author(int authorID, String authorName, int authorAge) {
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.authorID = authorID;
    }
}
