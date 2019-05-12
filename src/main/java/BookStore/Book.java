package BookStore;

public class Book {
    private String tytul;
    private String isbnNumer;
    private String rokWydania;
    private String slowo;

    public Book(String tytul, String isbnNumer, String rokWydania) {
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

    public String getRokWydania() {
        return rokWydania;
    }

    @Override
    public String toString() {
        return tytul +" " + rokWydania +" " + isbnNumer;
    }
}
