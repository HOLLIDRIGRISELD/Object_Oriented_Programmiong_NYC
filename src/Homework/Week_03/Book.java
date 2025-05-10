package Homework.Week_03;

public class Book {
    //Protected Variable for SubClass Access
    protected String ISBN;
    protected String Title;
    protected double Price;
    protected String Author;

    //Constructor to Make Protected Variables usable
    public Book(String ISBN, String Title, double Price, String Author) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Price = Price;
        this.Author = Author;
    }

    //Output when called
    public void DisplayBdata() { //Display Book Data
        System.out.println("Book:");
        System.out.println("Title: " + Title);
        System.out.println("Author: " +  Author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Price: " + Price);
    }
}

