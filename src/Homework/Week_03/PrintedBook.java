package Homework.Week_03;

public class PrintedBook extends Book {
    private boolean Hardcover;
    private int Pages;
    private String Publisher;
    private int Copies;

    //Constructor tha Adds up all the needed variables
    public PrintedBook(String ISBN, String Title, double Price, String Author, boolean Hardcover, int Pages, String Publisher, int Copies) {

        //super to call the Variables of the Book Class
        super(ISBN, Title, Price, Author);

        //Constructor to Make the Private Variables Usable
        this.Hardcover = Hardcover;
        this.Pages = Pages;
        this.Publisher = Publisher;
        this.Copies = Copies;
    }

    public void DisplayBdata() {
        //Display the General Book Data and then the extra ones
        super.DisplayBdata();

        //If Statement to Print the right Book format
        if (Hardcover) {
            System.out.println("Format: Hardcover");
        }
        else {
            System.out.println("Format: PaperBack");
        }

        System.out.println("Pages: " + Pages + ", Publisher: " + Publisher);
        System.out.println("Available Copies: " + Copies);
    }
}
