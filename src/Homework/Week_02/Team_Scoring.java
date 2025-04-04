package Homework.Week_02;

public class Team_Scoring {
    //Private Variables
    private String AwayTeam;
    private String HomeTeam;
    private int AwayScore;
    private int HomeScore;

    //Creating a Constructor to be able to work with the Private variables
    public Team_Scoring(String AwayTeam, String HomeTeam, int AwayScore, int HomeScore) {
        this.AwayTeam = AwayTeam;
        this.HomeTeam = HomeTeam;
        this.AwayScore = AwayScore;
        this.HomeScore = HomeScore;
    }

    //--Return Needed values--\\
    //AwayTeam
    public String getAwayTeam() {
        return AwayTeam;
    }
    //HomeTeam
    public String getHomeTeam() {
        return HomeTeam;
    }
    //AwayScore
    public int getAwayScore() {
        return AwayScore;
    }
    //HomeScore
    public int getHomeScore() {
        return HomeScore;
    }
}



