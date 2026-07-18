import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);

        Book[] books = new Book[100];
        int bookCount = 0;
        
        int option = 0;
        while (!(option == 9)) {
            System.out.println("=========================================================");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Avaliar livro");
            System.out.println("6 - Buscar livro pelo título");
            System.out.println("7 - Estatísticas");
            System.out.println("8 - Matriz de empréstimos");
            System.out.println("9 - Sair");

            System.out.print("Opção: ");
            option = consoleInput.nextInt();
            
            if (option == 1) {
                consoleInput.nextLine();
                System.out.print("Informe o título: ");
                String title = consoleInput.nextLine();
                
                System.out.print("Informe o autor: ");
                String author = consoleInput.nextLine();
                System.out.print("Informe o ISBN: ");
                String isbn = consoleInput.nextLine();

                books[bookCount] = new Book(title, author, isbn);
                bookCount++;
    
                System.out.println("\nNovo livro registrado com sucesso.");
            } else if (option == 2) {
                for (int count = 0; count < bookCount; count++) {
                    books[count].showInformation();
                }
            } else if (option == 3) {
                consoleInput.nextLine();
                System.out.print("Informe o título: ");
                String title = consoleInput.nextLine();
                System.out.println(title);
                boolean bookFound = false;
    
                for (int count = 0; count < bookCount; count++) {
                    if (books[count].getTitle().equalsIgnoreCase(title)) {
                        books[count].borrow();
                        bookFound = true;
                    }
                }
    
                if (bookFound == false) {
                    System.out.println("Livro inexistente");
                }
            } else if (option == 4) {
                consoleInput.nextLine();
                System.out.print("Informe o título: ");
                String title = consoleInput.nextLine();
                boolean bookFound = false;
    
                for (int count = 0; count < bookCount; count++) {
                    if (books[count].getTitle().equalsIgnoreCase(title)) {
                        books[count].returnBook();
                        bookFound = true;
                    }
                }
    
                if (bookFound == false) {
                    System.out.println("Livro inexistente");
                }
    
            } else if (option == 5) {
                consoleInput.nextLine();
                System.out.print("Informe o título: ");
                String title = consoleInput.nextLine();
    
                System.out.print("Informe a avaliação: ");
                double score = consoleInput.nextDouble();
    
                boolean bookFound = false;
    
                for (int count = 0; count < bookCount; count++) {
                    if (books[count].getTitle().equalsIgnoreCase(title)) {
                        books[count].rate(score);
                        bookFound = true;
                    }
                }
    
                if (bookFound == false) {
                    System.out.println("Livro inexistente");
                }
            } else if (option == 6) {
                consoleInput.nextLine();
                System.out.print("Informe o título: ");
                String title = consoleInput.nextLine();
    
                boolean bookFound = false;
    
                for (int count = 0; count < bookCount; count++) {
                    if (books[count].getTitle().equalsIgnoreCase(title)) {
                        books[count].showInformation();
                        bookFound = true;
                    }
                }
    
                if (bookFound == false) {
                    System.out.println("Livro inexistente");
                }
            } else if (option == 7) {
                int borrowedBookSum = 0;
                for (int count = 0; count < bookCount; count++) {
                    borrowedBookSum += books[count].getBorrowCount();
                }
    
                int availableBookSum = 0;
                for (int count = 0; count < bookCount; count++) {
                    if (books[count].isAvailable()) {
                        availableBookSum += 1;
                    }
                }
    
                double averageBookRating = 0;
                for (int count = 0; count < bookCount; count++) {
                    averageBookRating += books[count].getBorrowCount();
                }
                averageBookRating = averageBookRating / bookCount;
    
                int mostBorrowedBook = 0;
                String mostBorrowedBookTitle = new String();
                for (int count = 0; count < bookCount; count++) {
                    mostBorrowedBook = Math.max(mostBorrowedBook, books[count].getBorrowCount());
                }
                for (int count = 0; count < bookCount; count++) {
                    if (books[count].getBorrowCount() == mostBorrowedBook) {
                        mostBorrowedBookTitle = books[count].getTitle();
                    }
                }
    
                double highestBookRanking = 0;
                double lowestBookRanking = 0;
                ArrayList<String> highestBookRankingTitles = new ArrayList<String>();
                ArrayList<String> lowestBookRankingTitles = new ArrayList<String>();
                for (int count = 0; count < bookCount; count++) {
                    highestBookRanking = Math.max(highestBookRanking, books[count].getRating());
                    lowestBookRanking = Math.min(lowestBookRanking, books[count].getRating());
                }
    
                for (int count = 0; count < bookCount; count++) {
                    if (highestBookRanking == books[count].getRating()) {
                        highestBookRankingTitles.add(books[count].getTitle());
                    } else if (lowestBookRanking == books[count].getRating()) {
                        lowestBookRankingTitles.add(books[count].getTitle());
                    }
                }
                
    
                System.out.println("====================================================");
                System.out.printf("Total de livros registrados: %d\n", bookCount);
                System.out.printf("Total de livros emprestados: %d\n", borrowedBookSum);
                System.out.printf("Total de livros disponíveis: %d\n", availableBookSum);
                System.out.printf("Média de avaliação: %.2f\n", averageBookRating);
                System.out.print("Livro(s) mais avaliado(s): ");
                highestBookRankingTitles.forEach(book -> System.out.print(book + " "));
                System.out.print("\nLivro(s) menos avaliado(s): ");
                lowestBookRankingTitles.forEach(book -> System.out.print(book + " "));
                System.out.println();
            }
        }
    }
}