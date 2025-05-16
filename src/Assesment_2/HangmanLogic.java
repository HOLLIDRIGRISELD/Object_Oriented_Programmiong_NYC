package Assesment_2;

public class HangmanLogic {
    private String word;
    private char[] display;
    private int wrongGuesses;

    //constructor to make the variables usable
    public HangmanLogic(String word) {
        this.word = word;
        display = word.toCharArray();

        //reveal only the first and last char
        for (int i = 1; i < display.length - 1; i++) {
            display[i] = '-';
        }
        //counter of wrong guesses
        wrongGuesses = 0;
    }


    //guess if the lettre is in the word
    public boolean guess(char c) {
        //flag for if found
        boolean found = false;
        //loop to check the whole word
        for (int i = 1; i < word.length() - 1; i++) {
            //if it exists
            if (word.charAt(i) == c) {
                //revel the letter in the display
                display[i] = c;
                found = true;
            }
        }
        //if not found then add 1 to the counter
        if (!found) wrongGuesses++;
        return found;
    }


    //return if all letters were found
    public boolean isWin() {
        return new String(display).equals(word);
    }

    //return if player lost
    public boolean isLost() {
        return wrongGuesses >= 6;
    }

    //return the current run of the gam
    public String getDisplay() {
        return new String(display);
    }

    //return the word
    public String getFullWord() {
        return word;
    }

    //give the number to the counter
    public int getWrongGuesses() {
        return wrongGuesses;
    }
}