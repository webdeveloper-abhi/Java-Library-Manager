package idea.library;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem implements librarywork{

    Scanner sc=new Scanner(System.in);
    ArrayList<Book>books;
    Validate valides=new Validate();


    public LibraryManagementSystem(){
        books=new ArrayList<>();
    }

    @Override
    public void addBook(String id, String authorname, String title, double publishyear, String status, String date) {
        if (valides.validateBookId(id)) {
            Book book = new Book(id, authorname, title, publishyear, status, date);
            books.add(book);
        } else {
            System.out.println("Invalid Book ID. Book not added.");
        }
    }


    public void borrowBooks() {
        System.out.print("Enter Book Id: ");
        String id = sc.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getBookId().equals(id) && book.getStatus().equals("Available")) {
                System.out.println("Book Borrowed Successfully");
                book.setStatus("Not Available");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found in Library");
        }
    }

    public void returnBook() {
        System.out.print("Enter Book Id: ");
        String id = sc.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getBookId().equals(id) && book.getStatus().equals("Not Available") && valides.validateBookId(id)) {
                System.out.println("Book Returned Successfully");
                book.setStatus("Available");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book of Id Number " + id + " is not Available");
        }
    }

    @Override
    public void showAllBooks() {
        for(Book book:books){
            System.out.println(book.toString());
        }
    }

    @Override
    public void showAllAvailableBooks() {
        for(Book book:books){
            if(book.getStatus().equals("Available")){
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void exit() {
       return;
    }

    @Override
    public void searchBook(){
        System.out.print("Enter Book Title to Search: ");
        String title=sc.nextLine();
        boolean ispresent=false;

        for(Book book:books){
            if(book.getTitle().equals(title) && book.getStatus().equals("Available")){
                System.out.println(book.getTitle()+" "+title);
                System.out.println("Book Is Available");
                ispresent=true;

            }
            if(book.getTitle().equals(title) && book.getStatus().equals("Not Available")){
                System.out.println(book.getTitle()+" "+title);
                System.out.println("Book Is Borrowed Wait till it return");
                ispresent=true;

            }
        }
        if(!ispresent)System.out.println("Book is not Available");
    }

}
