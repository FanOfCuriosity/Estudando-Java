import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String isbn;
    
    private boolean available;
    private int borrowCount;
    private double rating;

    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;

        this.available = true;
    }

    public void borrow() {
        if (available) {
            this.available = false;
            System.out.println("Livro emprestado. Boa leitura!");
        } else {
            System.out.println("Lamento, livro já está em empréstimo.");
        }
    }

}
