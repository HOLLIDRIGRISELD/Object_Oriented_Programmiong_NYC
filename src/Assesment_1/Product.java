package Assesment_1;

public class Product {
    //private variables for protection
    private String Name;
    private double Price;

    //constructor to make the variables usable
    public Product(String Name, double Price) {
        this.Name = Name;
        this.Price = Price;
    }

    //differentiate name in case of a search
    public String getName(){
        return Name;
    }

    //change the price when modified
    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void displayProduct() {
        System.out.println("Name: " + Name);
        System.out.println("Price: " + Price + " $");
    }
}
