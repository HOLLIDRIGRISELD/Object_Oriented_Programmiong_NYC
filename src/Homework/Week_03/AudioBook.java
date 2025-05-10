package Homework.Week_03;

public class AudioBook extends Book {
    private int Minutes;
    private String Narrator;

    //Constructor tha Adds up all the needed variables
    public AudioBook(String ISBN, String Title, double Price, String Author, int Minutes, String Narrator) {

        //super to call the Variables of the Book Class
        super(ISBN, Title, Price, Author);

        this.Minutes = Minutes;
        this.Narrator = Narrator;
    }

    //output
    public void DisplayBdata() {

        //Display the General Book Data and then the extra ones
        super.DisplayBdata();

        System.out.println("Duration: " + Minutes +" Minutes");
        System.out.println("Narrator: " + Narrator );
    }
}
