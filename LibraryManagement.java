import java.util.*;

class Book {
    String name;
    int bookId;
    int isbn;
    int pages;
    double price;
    boolean isBorrowed;

    Book() {
        name = "Unknown Name";
        bookId = 0;
        isbn = 0;
        pages = 0;
        price = 0.0;
        isBorrowed = false;
    }

    Book(String name, int bookId, int isbn, int pages, double price) {
        this.name = name;
        this.bookId = bookId;
        this.isbn = isbn;
        this.pages = pages;
        this.price = price;
        this.isBorrowed = false;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Book ID: " + bookId);
        System.out.println("Book ISBN Number: " + isbn);
        System.out.println("No. of Pages: " + pages);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
        System.out.println("-----------------------------------");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n*** Library Management System ***");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter the name of the book: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter the Book ISBN number: ");
                    int isbn = sc.nextInt();
                    System.out.print("Enter the number of pages: ");
                    int pages = sc.nextInt();
                    System.out.print("Enter the price: ");
                    double price = sc.nextDouble();
                    books.add(new Book(name, id, isbn, pages, price));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available to borrow.");
                        break;
                    }
                    System.out.print("Enter the Book ID you want to borrow: ");
                    int borrowId = sc.nextInt();
                    boolean found = false;

                    for (Book book : books) {
                        if (book.bookId == borrowId) {
                            found = true;
                            if (book.isBorrowed) {
                                System.out.println("Sorry, this book is already borrowed.");
                            } else {
                                sc.nextLine(); // consume leftover newline
                                System.out.print("Enter Student's Name: ");
                                String studentName = sc.nextLine();
                                System.out.print("Enter Student's ID: ");
                                int studentId = sc.nextInt();
                                book.isBorrowed = true;
                                System.out.println("Book borrowed successfully by:");
                                System.out.println("Student Name: " + studentName + " | Student ID: " + studentId);
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book ID not found.");
                    }
                    break;

                case 3:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\n--- All Books ---");
                        for (Book book : books) {
                            book.display();
                        }
                    }
                    break;

                case 4:
                    boolean anyAvailable = false;
                    System.out.println("\n--- Available Books ---");
                    for (Book book : books) {
                        if (!book.isBorrowed) {
                            book.display();
                            anyAvailable = true;
                        }
                    }
                    if (!anyAvailable) {
                        System.out.println("No books available right now.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 5);

        sc.close();
    }
}
