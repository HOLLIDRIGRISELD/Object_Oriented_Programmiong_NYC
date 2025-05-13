package Homework.Week_03;

public class DigitalBook extends Book {
    private int Size;

    //Constructor tha Adds up all the needed variables
    public DigitalBook(String ISBN, String Title, double Price, String Author, int Size) {

        //super to call the Variables of the Book Class
        super(ISBN, Title, Price, Author);
        this.Size = Size;
    }

    //output
    public void DisplayBdata() {
        //super to get the general book data
        super.DisplayBdata();
        System.out.println("Size: " + Size + "KB");
    }
}
