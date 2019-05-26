package BookStore;

import java.util.ArrayList;
import java.util.List;

public class AuthorList {

    private static final AuthorList AUTHOR_LIST = new AuthorList();

    private static List<Author> authorList = new ArrayList<>();

    public static List<Author> getAuthorList() {
        return authorList;
    }
}
