package BookStore;

import java.util.ArrayList;
import java.util.List;

public class AuthorList {

    private static final AuthorList AUTHOR_LIST = new AuthorList();

    private static List<Author> authorsList = new ArrayList<>();

    public static List<Author> getAuthorsList() {
        return authorsList;
    }
}
