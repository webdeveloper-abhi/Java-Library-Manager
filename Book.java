package idea.library;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private double publishYear;
    private String status;

    private String date;

    public Book(String bookId,String title,String author,double publishYear,String status,String date){
        this.bookId=bookId;
        this.title=title;
        this.status=status;
        this.author=author;
        this.publishYear=publishYear;
        this.date=date;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public double getPublishYear() {
        return publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String reset = "\u001B[0m";
        String white = "\u001B[97m"; // White color

        String format = "| %-6s| %-20s| %-30s| %-12s| %-15s|%n";

        return white + String.format(format, bookId, author,title, publishYear, status) + reset;
    }





}
