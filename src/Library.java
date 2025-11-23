import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
    }
    public void printAllBooks() {
        System.out.println("Library: " + name);
        for(Book b : books) {
            b.printInfo();
        }
    }
}