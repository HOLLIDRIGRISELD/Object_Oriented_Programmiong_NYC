package Homework.Week_01_B;
import java.util.Scanner;

public class Pet_Clinic {
    public static void main(String[] args) {

        //Dint know if the user needed to fill the list so I filled it myself
        Pet[] pets = new Pet[10];
        pets[0] = new Pet("dog", "Pluto");
        pets[1] = new Pet("rabbit", "Mpampis");
        pets[2] = new Pet("dog", "Jack");
        pets[3] = new Pet("cat", "garfield");
        pets[4] = new Pet("dog", "Milou");
        pets[5] = new Pet("turtle", "leonardo");
        pets[6] = new Pet("cat", "cat_name");
        pets[7] = new Pet("duck", "Donald");
        pets[8] = new Pet("rabbit", "Bucks");
        pets[9] = new Pet("duck", "Dave");

        Scanner in = new Scanner(System.in);
        System.out.print("Give type: ");
        String Type = in.nextLine().trim();

        int count = 0;
        // Find and display pets that match the specified type
        for (Pet pet : pets) {
            if (pet.Get_Species().equals(Type)) {
                System.out.println("- " + pet.Get_Name());
                count++;
            }
        }

        System.out.println("Total animals of " + Type + " type: " + count);
        in.close();
    }
}
