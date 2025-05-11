package Homework.Week_04;

import java.sql.*;
import java.util.Scanner;

public class CoffeShop {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        //URL USER AND PASSWORD of the needed database
        String url = "jdbc:mysql://localhost:3306/coffeshop"; //basic mysql database url
        String user = "java"; //basic user with all privileges on the coffeshop database only
        String password = "1234";//an easy password
        /*if those variables dont work it is needed to
          create this particular user to your local machine
          and grant it privilages to the database named "coffeshop". */

        //try exception to connect to the database
        try {

            //connection from the sql library
            Connection conn = DriverManager.getConnection(url,user,password);
            //simple message to ensure that the connection was successful
            System.out.println("CONNECTED TO DATABASE.");

            //Creating a main menu
            while (true) {
                System.out.println();
                System.out.println("--- Coffee Shop Menu ---");
                System.out.println("[1] Add Order");
                System.out.println("[2] View Orders of a Date");
                System.out.println("[3] View Total Amount of a Customer");
                System.out.println("[0] Exit");
                System.out.print("Enter your choice: ");
                String Choice = read.nextLine();


                switch (Choice) {
                    case "1":
                        try {
                            //get the needed variables to insert
                            //OrderID
                            System.out.print("Enter Order ID: ");
                            int orderID = Integer.parseInt(read.nextLine()); //after encountering an error in the reading of    \\
                                                                             //data I found that the Integer.parseInt() fixed it\\
                            //Name
                            System.out.print("Enter Customer Name: ");
                            String name = read.nextLine();
                            //Price
                            System.out.print("Enter Order Price: ");
                            float price = Float.parseFloat(read.nextLine());
                            //Date
                            System.out.print("Enter Order Date (YYYY-MM-DD): ");
                            String date = read.nextLine();

                            //write the actual query
                            String query = "INSERT INTO orders (OrderID, Name, AmountPaid, Date) VALUES (?, ?, ?, ?)";
                            PreparedStatement ps = conn.prepareStatement(query);

                            //preparing the statement of the variables
                            ps.setInt(1, orderID);
                            ps.setString(2, name);
                            ps.setDouble(3, price);
                            ps.setString(4, date);
                            ps.executeUpdate();

                            System.out.println("Order Added.");
                        }
                        catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case "2":
                        //read the date
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = read.nextLine();

                        //write the query
                        String query = "SELECT * FROM orders WHERE Date = ?";
                        PreparedStatement ps = conn.prepareStatement(query);

                        //switch ? with the actual date
                        ps.setString(1, date);
                        ResultSet rs = ps.executeQuery();

                        //print all orders in that date
                        while (rs.next()) {
                            System.out.println("OrderID:"+rs.getInt("OrderId")+" Name:"+rs.getString("Name")+" Amount Paid:"+rs.getDouble("AmountPaid")+" Date:"+rs.getString("Date"));
                        }
                        break;

                    case "3":
                        //read the needed variable
                        System.out.print("Enter Customer Name: ");
                        String Name = read.nextLine();

                        //write the query
                        String query2 = "SELECT SUM(AmountPaid) AS Total FROM orders WHERE Name = ?"; //needed a new query variable
                        PreparedStatement ps2 = conn.prepareStatement(query2);
                        ps2.setString(1, Name);
                        ResultSet rs2 = ps2.executeQuery();

                        //if statement to print the output or a message that the user is not found
                        if (rs2.next()) {
                            System.out.println("The Total Amount of a Customer is: "+rs2.getDouble("Total")+"$");
                        } else {
                            System.out.println("No orders found for that customer.");
                        }
                        break;

                    case "0":
                        System.out.println("EXITING");
                        return;
                    //if anything else
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
