package Assesment_1;

public class Electronics extends Product {
    private String Brand;
    private int Warranty;

    //constructor to make the variables usable
    public Electronics(String Name, double Price, String Brand, int Warranty) {
        //super to make the general variables usable
        super(Name, Price);
        this.Brand = Brand;
        this.Warranty = Warranty;
    }


    public void displayProduct() {
        //super to display the general Product Data
        super.displayProduct();
        //display the extra data
        System.out.println("Brand: " + Brand);
        System.out.println("Warranty: " + Warranty + "Years");
    }
}