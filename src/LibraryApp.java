import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    ArrayList<Book> books = new ArrayList<Book>();
    private Scanner sc = new Scanner(System.in);
    private int choice;

    public void run() {
        do {
            System.out.println("Welcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Enter your choice (1-7): ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    this.printAllBooks();
                    break;
                case 2:
                    this.addNewBook();
                    break;
                case 3:
                    this.searchBooksByTitle();
                    break;
                case 4:
                    this.borrowABook();
                    break;
                case 5:
                    this.returnABook();
                    break;
                case 6:
                    this.deleteABookById();
                    break;
                default:
                    break;
            }
        } while (choice != 7);
    }

    public void printAllBooks() {
        if (books.size() == 0) {
            System.out.println("No books in the library\n");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    public void addNewBook() {
        System.out.print("Enter the title of the book: ");
        String title = sc.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = sc.nextLine();

        System.out.print("Enter the year of publication: ");
        int year = sc.nextInt();

        books.add(new Book(title, author, year));
    }

    public void searchBooksByTitle() {
        System.out.print("Enter the title of the book: ");
        String titlePart = sc.nextLine();
        int amount = 0;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(titlePart.toLowerCase())) {
                System.out.println(book.getTitle());
                amount++;
            }
        }

        System.out.println(amount + " books were found");
    }

    public void borrowABook() {
        System.out.print("Enter the ID of the book: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.getAvaliable()) {
                    book.markAsBorrowed();
                } else {
                    System.out.println("The book is already borrowed");
                }
            }
        }
    }

    public void returnABook() {
        System.out.print("Enter the ID of the book: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.getAvaliable()) {
                    book.markAsReturned();
                }
            }
        }
    }

    public void deleteABookById() {
        System.out.print("Enter the ID of the book: ");
        int id = sc.nextInt();
        int amount = 0;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                amount++;
            }
        }

        if (amount == 0) {
            System.out.println("Book not found ");
        }
    }
}
