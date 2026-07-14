import java.util.ArrayList;

public class Book {
    private ArrayList<String> title;
    private ArrayList<String> author;
    private ArrayList<String> isbn;
    
    private ArrayList<Boolean> available;
    private ArrayList<Integer> borrowCount;
    private ArrayList<Double> rating;

    
    public Book(ArrayList<String> title, ArrayList<String> author, ArrayList<String> isbn, ArrayList<Boolean> available) {
        this.title.addAll(title);
        this.author.addAll(author);
        this.isbn.addAll(isbn);
        this.available.add(false);
    }

}
