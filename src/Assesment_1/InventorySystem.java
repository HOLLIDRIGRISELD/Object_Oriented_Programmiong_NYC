package Assesment_1;
import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        productManager.SampleProducts();

        //Create a main menu
        while (true) {
            //Main MENU
            System.out.println(":MENU:");
            System.out.println("[1].Add Product"); //in the price the number need to be like "12,99" not "12.99"
            System.out.println("[2].Show Products");
            System.out.println("[3].Search Product");
            System.out.println("[4].Update Product"); //in the price the number need to be like "12,99" not "12.99"
            System.out.println("[0].Exit");
            System.out.print("Your Choice: ");
            String choice = sc.nextLine();


            switch (choice) {
                //Add Products
                case "1":
                    productManager.addProduct();
                    break;
                //Show Products
                case "2":
                    productManager.printProducts();
                    break;
                //Search Products
                case "3":
                    productManager.searchProducts();
                    break;
                //Update Products
                case "4":
                    productManager.modifyProduct();
                    break;
                case "0":
                    System.out.println("Exit...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
