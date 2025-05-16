package Assesment_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//main window of the hangman game
public class GameWindow extends JFrame {
    //all the needed varables
    private User user;
    private DatabaseManager db;
    private HangmanLogic logic;
    private JLabel wordLabel;
    private JLabel statusLabel;
    private JTextField inputField;
    private JButton logoutBtn;
    private JLabel guessInfoLabel;
    private JButton guessBtn;

    //main game window
    public GameWindow(User user, DatabaseManager db) {
        this.user = user;
        this.db = db;

        //Window settings
        setTitle("HANGMAN GAME");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        setResizable(false);

        //get the random word
        String word = WordAPI.getWord();
        //get logic for the game
        logic = new HangmanLogic(word);

        //create the needed labels,input , and button
        wordLabel = new JLabel(logic.getDisplay(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        wordLabel.setForeground(new Color(0, 0, 0));
        statusLabel = new JLabel("GUESS A LETTER", SwingConstants.CENTER);
        guessInfoLabel = new JLabel("GUESSES LEFT: 6",SwingConstants.CENTER);
        inputField = new JTextField();
        inputField.setEditable(true);
        logoutBtn = new JButton("--> LOGOUT");
        logoutBtn.setFont(new Font("Roboto", Font.BOLD, 15));

        //add actions to input files and the logout button
        inputField.addActionListener(new GuessHandler());
        logoutBtn.addActionListener(new LogoutHandler());


        //add the above to the main window
        add(wordLabel);
        add(statusLabel);
        add(guessInfoLabel);
        add(inputField);
        add(logoutBtn);

        //make the window visible
        setVisible(true);
    }

    //handle all the guesses
    class GuessHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //read letter
            String text = inputField.getText();
            //clear the input field
            inputField.setText("");

            //check is the text is single letter
            if (text.length() == 1 && Character.isLetter(text.charAt(0))) {
                //update the displayed word
                boolean correct = logic.guess(text.charAt(0));
                wordLabel.setText(logic.getDisplay());

                //Add message depending on the letter being correct or not
                if (correct) {
                    statusLabel.setText("CORRECT!");
                }
                else {
                    statusLabel.setText("INCORRECT GUESS!");
                }

                //make a reverse counter
                int guessLeft = 6 -logic.getWrongGuesses();
                guessInfoLabel.setText("GUESS LEFT: " + guessLeft);


                //check if the game is won or not
                if (logic.isWin()) {
                    statusLabel.setForeground(new Color(0, 255, 0));
                    statusLabel.setText("YOU WIN!");
                    inputField.setEnabled(false);
                    try {
                        //update the score of the user
                        db.updateStats(user.getUsername(), true);
                    }
                    catch (SQLException ex) {}
                } else if (logic.isLost()) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("YOU LOST THE WORD WAS: " + logic.getFullWord());
                    inputField.setEditable(false );
                    try {
                        //update the score of the user
                        db.updateStats(user.getUsername(), false);
                    }
                    catch (SQLException ex) {}
                }
            }
        }
    }

    //logout
    class LogoutHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //before loging out show leaderboard
            new LeaderboardWindow(db);
            dispose();
        }
    }
}
