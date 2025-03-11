package Homework.Week_01_A;

import java.util.Scanner;

class Rectangle {
    private final int width;
    private final int height;

    //we need a constructor to make the variables usable
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //main loop to draw the shapes
    public void Print() {

        //Top
        for (int i = 0; i < width; i++) {
            System.out.print("* ");
        }
        System.out.println();

        //Half
        for (int i = 1; i < height - 1; i++) {
            System.out.print("*");
            for (int j = 1; j < width - 1; j++) {
                System.out.print("  ");
            }
            if (width > 1) {
                System.out.print(" *");
            }
            System.out.println();
        }

        //Bottom
        if (height > 1) {
            for (int i = 0; i < width; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

//Dint know if a needed a separate class so i made it in the same file
public class Geometry {
    public static void main(String[] args) {

        //exercises main output
        Rectangle r1 = new Rectangle(10, 5);
        Rectangle r2 = new Rectangle(6, 8);

        r1.Print();
        System.out.println();
        r2.Print();

        //custom rectangle of user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter width: ");
        int w = in.nextInt();
        System.out.print("Enter height: ");
        int h = in.nextInt();

        Rectangle r3 = new Rectangle(w, h);
        r3.Print();


    }
}

