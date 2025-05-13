package Assesment_1;

public class Grocery extends Product {
    private double Weight;
    private String Expiration;

    //Constructor to make the variables usable
    public Grocery(String Name, double Price, double Weight, String Expiration) {
        //super to make the general variables usable
        super(Name, Price);
        this.Weight = Weight;
        this.Expiration = Expiration;
    }


    //
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Weight: " + Weight + "Kilos");
        System.out.println("Expiration: " + Expiration);
    }
}

