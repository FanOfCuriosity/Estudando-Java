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
            this.borrowCount++;
            System.out.println("Livro emprestado. Boa leitura!");
        } else {
            System.out.println("Lamento, livro já está em empréstimo.");
        }
    }

    public void returnBook() {
        // If available is false—meaning the book is on loan—the condition will be triggered by its negation, becoming true only if the value is false.
        if (!available) {
            this.available = true;
            System.out.println("Livro devolvido. Muito obrigado!");
        } else {
            System.out.println("Lamento, o livro já está devolvido.");
        }
    }

    public void rate(double score) {
        if (score >= 0 && score <= 10) {
            this.rating = score;
            System.out.println();
        } else {
            System.out.println("A avaliação não pode ser maior que 10 ou negativa.");
        }
    }
}
