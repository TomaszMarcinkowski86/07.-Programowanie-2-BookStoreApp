package BookStore;

public class Book {
    private String tytul;
    private String isbnNumer;
    private int rokWydania;


    public Book(String tytul,int rokWydania, String isbnNumer) {
        this.tytul = tytul;
        this.isbnNumer = isbnNumer;
        this.rokWydania = rokWydania;
    }


    public String getTytul() {
        return tytul;
    }

    public String getIsbnNumer() {
        return isbnNumer;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    @Override
    public String toString() {
        return tytul +" " + rokWydania +" " + isbnNumer;
    }
}
