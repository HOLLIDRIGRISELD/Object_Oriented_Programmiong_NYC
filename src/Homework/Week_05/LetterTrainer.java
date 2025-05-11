package Homework.Week_05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class LetterTrainer {
    public static void main(String[] args) {
        //Create the main window
        JFrame frame = new JFrame(":LETTER TRAINER:");
        //Make the program close with the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        //Extract the list of animals form the AnimalData
        List<Animal> animals = AnimalData.getAnimals();
        int[] i = {0};

        //Create labels to show the:
        //Image,Starting Letter and result message
        JLabel imageLabel = new JLabel();
        JTextField inputField = new JTextField(1);
        JLabel messageLabel = new JLabel();

        //Create buttons for the check and next as the example on teams
        JButton checkButton = new JButton("CHECK");
        JButton nextButton = new JButton("NEXT");

        //Show the first image form the images folder
        updateImage(imageLabel, animals.get(i[0]));

        //Check Button Actions
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //get input and remove any extra spaces and make it lowercase if needed
                String input = inputField.getText().trim().toUpperCase();
                //get the name of the animal frm the list
                Animal current = animals.get(i[0]);

                //check if the letter is correct
                if (input.equals(current.getLetter())) {
                    messageLabel.setText("CORRECT ! THE " + current.getLetter() + "LETTER IS FOR THE " + current.getName());
                    nextButton.setEnabled(true);
                } else {
                messageLabel.setText("WRONG LETTER! TRY  AGAIN!");}
            }
        }
        );

        //Next Button Actions
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Add +1 to the list to go to the next animal
                i[0] = (i[0] + 1);
                //show the new image
                updateImage(imageLabel, animals.get(i[0]));

                //reset the message and the input to blank again
                inputField.setText("");
                messageLabel.setText("");
            }
        }
        );

        //make the image panel centered
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);

        //make the panel to have the input, the check and the message
        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(checkButton);
        inputPanel.add(messageLabel);

        //make the next centered with a panel
        JPanel nextPanel = new JPanel();
        nextPanel.add(nextButton);

        //Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        // Add image, input, and next button
        mainPanel.add(imagePanel);
        mainPanel.add(inputPanel);
        mainPanel.add(nextPanel);
        // Add main panel to the frame and show the window
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    //Change the Image of the label
    private static void updateImage(JLabel label, Animal animal) {
        //add a new image from the path
        ImageIcon icon = new ImageIcon(animal.getImagePath());
        //resize the image
        Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH); //I found scale smooth and it worked good for this purpose
        //show the new image
        label.setIcon(new ImageIcon(img));
    }
}

