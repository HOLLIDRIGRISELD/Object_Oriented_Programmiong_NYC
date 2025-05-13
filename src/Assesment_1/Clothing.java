package Assesment_1;

public class Clothing extends Product{
    private String Size;
    private String Material;
    private String Color;

    //Constructor to make the variables usable
    public Clothing(String Name, double Price, String Size, String Material, String Color) {
        //super to make the general variable usable
        super(Name, Price);
        this.Size = Size;
        this.Material = Material;
        this.Color = Color;
    }


    public void displayProduct() {
        //super to display the general data of the product
        super.displayProduct();
        System.out.println("|Clothing Specifications| ");
        System.out.println("Size: " + Size);
        System.out.println("Material: " + Material);
        System.out.println("Color: " + Color);
    }
}
