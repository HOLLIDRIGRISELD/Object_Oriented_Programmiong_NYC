package Homework.Week_01_C;

public class Car {
    private String plateNumber;
    private String model;
    private int kilometers;
    private boolean isRented;

    // Constructor to initialize a new Car object
    public Car(String plateNumber, String model, int kilometers) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.kilometers = kilometers;
        this.isRented = false; // Default to not rented
    }

    // Getters and Setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public boolean isRented() {
        return isRented;
    }

    // Rent the car (set isRented to true)
    public void rentCar() {
        this.isRented = true;
    }

    // Return the car (set isRented to false and update kilometers)
    public void returnCar(int newKilometers) {
        this.isRented = false;
        this.kilometers = newKilometers;
    }

    // Display car details

    public String toString() {
        return "Plate Number: " + plateNumber + ", Car Model: " + model + ", Kilometers: " + kilometers + ", Rented: " + isRented;
    }
}

