package Homework.Week_02;
import java.util.Scanner;

class Main_Game {
    public static void main(String[] args) {

        Game_Data game = new Game_Data();
        Scanner read = new Scanner(System.in);

        //An infinite loop until Choice == 3 Which is The Exit
        while (true) {
            //Main Menu
            System.out.println("[1] Add Game ");
            System.out.println("[2] Team Perfomance ");
            System.out.println("[3] Exit ");
            System.out.println();
            System.out.print("Enter your choice: ");
            String Choice = read.nextLine();

            //A switch for each Choice
            switch (Choice) {
                //Choice = 1
                case "1":
                    System.out.print("Enter the name of the Away Team: ");
                    String AwayTeam = read.nextLine();

                    System.out.print("Enter the name of the HomeTeam: ");
                    String HomeTeam = read.nextLine();

                    System.out.print("Away Score: ");
                    int AwayScore = read.nextInt();

                    System.out.print("Home Score: ");
                    int HomeScore = read.nextInt();
                    read.nextLine();

                    game.AddGame(AwayTeam, HomeTeam, AwayScore, HomeScore);
                    break;

                //Choice = 2
                case "2":
                    System.out.print("Give me the Name  of the Team: ");
                    String Team = read.nextLine();
                    game.TeamPerformance(Team);
                    break;

                //Choice = 3
                case "3":
                    System.out.println("Exiting...");
                    return;

                //Choice = Anything else
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }
}
