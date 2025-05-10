package Homework.Week_03;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookStore {
    public static void main(String[] args) {

        //array list to store all books
        ArrayList<Book> books = new ArrayList<Book>();

        //AUDIOBOOK\\
        books.add(new AudioBook("1718502702", "Python Crash Course", 9.99, "Eric Matthes", 480,"Morgan Freeman"));
        //DIGITALBOOK\\
        books.add(new DigitalBook("1569319014", "One Peice Vol:1", 13.99,"Eiichiro Oda",723));
        //PrintedBook\\
        //HardCover
        books.add(new PrintedBook("149207800X","Head First Design Pattern",43.99, "Eric Freeman , Elisabeth Robson", true,699,"O'Reilly Media",600));
        //PaperBack
        books.add(new PrintedBook("1718501064","Practical SQL",27.99, "Anthony DeBarros",false,464,"No Starch Press", 330));

        //Display all Book's Information
        for (Book book : books) {
            book.DisplayBdata();
            System.out.println();
        }
    }
}
