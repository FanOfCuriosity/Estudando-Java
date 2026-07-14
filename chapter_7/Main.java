import java.util.Scanner;

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
        }

        if (option == 1) {
            System.out.print("Informe o título: ");
            String title = consoleInput.nextLine();
            
            System.out.print("Informe o autor: ");
            String author = consoleInput.nextLine();

            System.out.print("Informe o ISBN: ");
            String isbn = consoleInput.nextLine();

            books[bookCount] = new Book(title, author, isbn);
            bookCount++;

            System.out.println("Novo livro registrado com sucesso.");
        }
    }
}