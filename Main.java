package idea.library;

import java.util.Scanner;

public class Main {
    static LibraryManagementSystem library = new LibraryManagementSystem();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeDatabase();

        System.out.println("LIBRARY MANAGEMENT SYSTEM");

        int choice;
        boolean headerPrinted = false; // To keep track of whether the header has been printed

        do {
            System.out.println("Your Preference\n");
            System.out.println("1-> Add Books");
            System.out.println("2-> Show All Books");
            System.out.println("3-> Show All Available Books");
            System.out.println("4-> Borrow Book");
            System.out.println("5-> Return Book");
            System.out.println("6-> Search Book");
            System.out.println("7-> Exit\n");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book Id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorname = sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Publish Year: ");
                    double publishyear = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character
                    library.addBook(id, authorname, title, publishyear, "Available", "01/01/20XX"); // You can replace "01/01/20XX" with an actual date
                    System.out.println("Book added successfully.");
                }
                case 2 -> {
                    if (!headerPrinted) {
                        printHeader();
                        headerPrinted = true;
                    }
                    library.showAllBooks();
                }
                case 3 -> {
                    if (!headerPrinted) {
                        printHeader();
                        headerPrinted = true;
                    }
                    library.showAllAvailableBooks();
                }
                case 4 -> library.borrowBooks();
                case 5 -> library.returnBook();
                case 6 -> library.searchBook();
                case 7 -> library.exit();
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 6);
    }

    static void initializeDatabase() {
        library.addBook("1", "Abhijeet", "Java", 2023, "Available", "25-10-23");
        library.addBook("2", "Ashitosh", "Python", 2022, "Available", "20-10-22");
        library.addBook("3", "Atmaram", "Frontend", 2024, "Available", "25-9-24");
        library.addBook("4", "Aniket", "Backend", 2020, "Available", "25-11-20");
        library.addBook("5", "Lahu", "Fullstack", 2025, "Available", "25-12-25");
    }

    static void printHeader() {
        String reset = "\u001B[0m";
        String orange = "\u001B[38;2;255;165;0m";
        String white = "\u001B[97m";

        System.out.println(orange + "-----------------------------------------------------------------------------------------------" + reset);
        System.out.println(orange + "| ID    | TITLE                | AUTHOR               | YEAR         | STATUS         |" + reset);
        System.out.println(orange + "-----------------------------------------------------------------------------------------------" + reset);
    }

}
