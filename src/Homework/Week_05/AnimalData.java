package Homework.Week_05;
import java.util.ArrayList;
import java.util.List;

public class AnimalData {
    //List of Animals and their Data like:
    //Name,Letter,and,Image
    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        //i had some problems in the Image path so I just copied the whole path and it worked
        animals.add(new Animal("Alligator", "A", "src/Homework/Week_05/images/alligator.png"));
        animals.add(new Animal("Bear", "B", "src/Homework/Week_05/images/bear.png"));
        animals.add(new Animal("Cat", "C", "src/Homework/Week_05/images/cat.png"));
        animals.add(new Animal("Dog", "D", "src/Homework/Week_05/images/dog.png"));
        animals.add(new Animal("Elephant", "E", "src/Homework/Week_05/images/elephant.png"));
        animals.add(new Animal("Ferret", "F", "src/Homework/Week_05/images/ferret.png"));
        animals.add(new Animal("Gorilla", "G", "src/Homework/Week_05/images/gorilla.png"));
        animals.add(new Animal("Horse", "H", "src/Homework/Week_05/images/horse.png"));
        animals.add(new Animal("Iguana", "I", "src/Homework/Week_05/images/iguana.png"));
        animals.add(new Animal("Jaguar", "J", "src/Homework/Week_05/images/jaguar.png"));
        return animals;
    }
}