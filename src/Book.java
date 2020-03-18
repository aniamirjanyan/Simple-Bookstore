public class Book {

    private String title, author, genre, text;
    private int ID, price, copies;

    public Book() {

    }

    public Book(int ID, String title, String author, String genre, int price, int copies) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.copies = copies;
    }

    public Book(int ID, String title, String author, String genre, int price, int copies, String text) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.copies = copies;
        this.text = text;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", text='" + text + '\'' +
                ", ID=" + ID +
                ", price=" + price +
                ", copies=" + copies +
                '}';
    }
}
