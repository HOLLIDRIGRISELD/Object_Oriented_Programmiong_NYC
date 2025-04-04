package Homework.Week_02;
import java.util.ArrayList;

public class Game_Data {
    //Create an Array to keep track of the Matches
    private ArrayList<Team_Scoring> Teams_Data = new ArrayList<>();

    //If Choice is 1 on the Main_Game Class.
    public void AddGame(String AwayTeam, String HomeTeam, int AwayScore, int HomeScore) {
        Teams_Data.add(new Team_Scoring(AwayTeam, HomeTeam, AwayScore, HomeScore));
    }

    //IF Choice is 2 on the Main_Game CLass
    public void TeamPerformance(String targetTeam) {
        //Create Counters for wins losses and draws
        int wins = 0 ;
        int losses = 0;
        int draws = 0;

        //A for loop in the Length of the Teams_Data
        for (Team_Scoring game : Teams_Data) {

            //Hometeam == TargetTeam
            if (game.getHomeTeam().equals(targetTeam)) {
                //Add To Counter Depending On The Circumstance\\
                //Home team Wins
                if (game.getHomeScore() > game.getAwayScore()) {
                    wins++;
                }
                //Home team Losses
                else if (game.getHomeScore() < game.getAwayScore()) {
                    losses++;
                }
                //It's a Draw
                else {
                    draws++;
                }
            }
            //AwayTeam == TargetTeam
            else if (game.getAwayTeam().equals(targetTeam)) {
                //Add To Counter Depending On The Circumstance\\
                //Away team Wins
                if (game.getAwayScore() > game.getHomeScore()) {
                    wins++;
                }
                //Away team losses
                else if (game.getAwayScore() < game.getHomeScore()) {
                    losses++;
                }
                //It's a Draw
                else {
                    draws++;
                }
            }
        }

        //Print the Outputs
        System.out.println("The team" + targetTeam + " has: ");
        System.out.println();
        System.out.println("Wins: " + wins + ", Losses: " + losses + ", Draws: " + draws);
    }
}
