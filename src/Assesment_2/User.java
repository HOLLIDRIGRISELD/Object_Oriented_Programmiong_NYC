package Assesment_2;

public class User {
    private String username;
    private int matchPlayed;
    private int matchWon;

    //constructor to make the variables usable
    public User(String username, int matchPlayed, int matchWon) {
        this.username = username;
        this.matchPlayed = matchPlayed;
        this.matchWon = matchWon;
    }

    //get the username of the user
    public String getUsername() {
        return username;
    }

    //get the new played matches
    public int getMatchPlayed() {
        return matchPlayed;
    }

    //get the new won matches
    public int getMatchWon() {
        return matchWon;
    }
}