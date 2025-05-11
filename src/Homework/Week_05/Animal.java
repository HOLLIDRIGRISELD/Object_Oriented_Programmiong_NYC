package Homework.Week_05;

public class Animal {
    private String Name;
    private String Letter;
    private String ImagePath;

    //constructor to make the variables usable
    public Animal(String Name, String Letter, String ImagePath) {
        this.Name = Name;
        this.Letter = Letter;
        this.ImagePath = ImagePath;
    }

    //output for each variable when called
    public String getName() { return Name; }
    public String getLetter() { return Letter; }
    public String getImagePath() { return ImagePath; }
}

