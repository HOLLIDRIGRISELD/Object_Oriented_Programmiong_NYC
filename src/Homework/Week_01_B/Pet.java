package Homework.Week_01_B;

public class Pet {
    private String specie;
    private String name;

    //we need a constructor to make the private variables usable
    public Pet(String specie, String name) {
        this.specie = specie;
        this.name = name;
    }

    //main function to return the Type of Pet
    public String Get_Species() {
        return specie;
    }

    //main function to return the Name of Pet
    public String Get_Name() {
        return name;
    }
}
