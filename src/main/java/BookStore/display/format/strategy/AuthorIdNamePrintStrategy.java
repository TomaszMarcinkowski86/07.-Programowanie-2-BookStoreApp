package BookStore.display.format.strategy;

import BookStore.Author;

import java.util.List;

public class AuthorIdNamePrintStrategy implements AuthorPrintStrategy {
    @Override
    public void print(List<Author> authorsList) {
        for (Author author : authorsList) {
            System.out.println
                    (author.getAuthorID()+ " " + author.getAuthorName());
        }
    }
}
