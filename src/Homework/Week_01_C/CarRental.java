package Homework.Week_01_C;
import java.util.Scanner;

public class CarRental {
    private Car[] cars;

    //Constructor for the available
    public CarRental() {
        cars = new Car[5];
        cars[0] = new Car("YSN123", "Mercedes Benz", 150000);
        cars[1] = new Car("AFG564", "Toyota Corolla", 240000);
        cars[2] = new Car("PLS724", "Audi A4", 30000);
        cars[3] = new Car("BNM012", "Nissan Skyline", 915000);
        cars[4] = new Car("PLM981", "Honda Civic", 470000);
    }

    //Choice 1
    public void rentCar(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                if (car.isRented()) {
                    System.out.println("The car with Plate Number: " + plateNumber + " is already rented.");
                }
                else {
                    car.rentCar();
                    System.out.println("The car with Plate Number " + plateNumber + " has been rented.");
                }
                return;
            }
        }
        System.out.println("The car with plate " + plateNumber + " was not found.");
    }

    //Choice 2
    public void returnCar(String plateNumber, int newKilometers) {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                if (car.isRented()) {
                    car.returnCar(newKilometers);
                    System.out.println("The car with Plate Number" + plateNumber + " has been returned. The new KiloMeters are: " + newKilometers);
                } else {
                    System.out.println("The car with Plate Number" + plateNumber + " was not rented.");
                }
                return;
            }
        }
        System.out.println("The car with Plate Number" + plateNumber + " was not found.");
    }

    //Choice 3
    public void displayCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    //Main Class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRental rentalSystem = new CarRental();

        //loop until exit
        while (true) {

            //Main Menu
            System.out.println("Car Rental Menu:");
            System.out.println("[1]-Rent a car");
            System.out.println("[2]-Return a car");
            System.out.println("[3]-Display all cars");
            System.out.println("[0]-Exit");
            System.out.println(" ");
            System.out.print("Please select an option: ");

            //Ask user for his Choice
            int choice = scanner.nextInt();
            scanner.nextLine();


            //cases
            switch (choice) {
                //rent case
                case 1:
                    System.out.print("Enter the Plate Number: ");
                    String rentPlate = scanner.nextLine();
                    rentalSystem.rentCar(rentPlate);
                    break;

                //return case
                case 2:
                    System.out.print("Enter the Plate Number: ");
                    String returnPlate = scanner.nextLine();
                    System.out.print("Enter the new KiloMeters:");
                    int newKilometers = scanner.nextInt();
                    rentalSystem.returnCar(returnPlate, newKilometers);
                    break;

                //Show all cars case
                case 3:
                    rentalSystem.displayCars();
                    break;

                //Exit case
                case 0:
                    System.out.println("Exiting Program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

