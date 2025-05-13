package Assesment_1;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    //Array list to store all products
    ArrayList<Product> products = new ArrayList<Product>();
    Scanner sc = new Scanner(System.in);

    //Store sample products
    public void SampleProducts() {
        products.add(new Electronics("Laptop H23KL", 1200.00, "Lenovo", 2));
        products.add(new Electronics("Projector", 432.00, "HP", 4));
        products.add(new Grocery("Milk", 2.99, 2, "2025-05-11"));
        products.add(new Grocery("Chicken", 5.99, 4, "2025-05-27"));
        products.add(new Clothing("Pants", 15.78, "XL", "Cotton", "Black"));
        products.add(new Clothing("Jacket", 29.87, "M", "Leather", "Brown"));
    }



    public void addProduct() {

        //Loop Until the user picked one of the 3 options
        String category;
        while (true) {
            //Ask user what category of product they want to add
            System.out.println("Enter Product Category: [Electronics] [Groceries] [Clothing] ");
            category = sc.nextLine();
            if (category.equals("Electronics") || category.equals("Groceries") || category.equals("Clothing")) {
                break;
            }
        }

        //Ask the user for the general variables
        System.out.println("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Product Price: ");
        double price = sc.nextDouble();
        sc.nextLine(); // consume newline


        //Switch cases for each product
        switch (category) {
            //Electronics Case
            case "Electronics":
                System.out.println("Brand: ");
                String brand = sc.nextLine();
                System.out.println("Warranty in years: ");
                int warranty = sc.nextInt();
                sc.nextLine(); // consume newline

                //Add the product to list
                products.add(new Electronics(name, price, brand, warranty));
                break;

            //Groceries Case
            case "Groceries":
                System.out.println("Weight in kilos: ");
                double kg = sc.nextDouble();
                sc.nextLine(); // consume newline
                System.out.println("Expiration Date: YYYY-MM-DD");
                String date = sc.nextLine();

                //Add the product to list
                products.add(new Grocery(name, price, kg, date));
                break;

            //Clothing Case
            case "Clothing":
                System.out.println("Size: [XS] [S] [M] [L] [XL]");
                String size = sc.nextLine();
                System.out.println("Material: ");
                String material = sc.nextLine();
                System.out.println("Color: ");
                String color = sc.nextLine();

                //Add the product to the list
                products.add(new Clothing(name, price, size, material, color));
                break;

            default:
                System.out.println("Invalid Category");
                break;
        }
    }

    //Display all products
    public void printProducts() {
        int number = 1;
        for (Product I : products) {
            System.out.println("Product Number " + number );
            I.displayProduct();
            System.out.println();
            number++;
        }
    }

    //search all the products
    public void searchProducts() {
        System.out.println("Enter the Name of the Product you want to search: ");
        String name = sc.nextLine();
        //Flag to a case a product is not found to display a message
        boolean flag = false;

        //for loop to search the list
        for (Product I : products) {
            //is the Product name is equal to the searched name
            if (I.getName().equalsIgnoreCase(name)) {
                I.displayProduct();
                flag = true;
            }
        }

        //if the product was not found display a message
        if (!flag) {
            System.out.println("Product Not Found");
        }
    }

    //update the price on a specific product
    public void modifyProduct() {
        System.out.println("Enter the Name of the Product you want to Modify: ");
        String name = sc.nextLine();
        //Flag to a case a product is not found to display a message
        boolean flag = false;

        //for loop to search the list
        for (Product I : products) {
            //is the Product name is equal to the searched name
            if (I.getName().equalsIgnoreCase(name)) {
                System.out.println("Enter the New Price of the Product: ");
                double Price = sc.nextDouble();
                sc.nextLine(); // consume newline
                I.setPrice(Price);
                System.out.println("The new price is now " + Price);
                flag = true;
                break;
            }
        }

        //if the product was not found display a message
        if (!flag) {
            System.out.println("Product Not Found");
        }
    }
}
