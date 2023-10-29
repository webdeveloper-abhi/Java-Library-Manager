package idea.library;

public interface librarywork {

    void addBook(String id,String authorname,String title,double publishyear,String status,String date);

    void showAllAvailableBooks();
    void showAllBooks();
    void borrowBooks();
    void returnBook();

    void exit();

    void searchBook();
}
