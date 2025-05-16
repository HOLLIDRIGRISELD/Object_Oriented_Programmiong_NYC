package Homework.Week_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class LetterTrainer {
    public static void main(String[] args) {

        // Create the main window
        JFrame frame = new JFrame("LETTER TRAINER");
        // Make the program close when window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make the size of the window locked
        frame.setResizable(false);


        // Get the list of animals from AnimalData
        List<Animal> animals = AnimalData.getAnimals();
        int[] index = {0};


        // Create label to display the image
        JLabel imageLabel = new JLabel();
        // Create input field to type one letter
        JTextField inputField = new JTextField(2);
        // Create a label to show messages like correct and wrong
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        //add font types and sizing of the texts
        messageLabel.setFont(new Font("Arial", Font.BOLD, 15));


        // Create the check and the next button
        JButton checkButton = new JButton("[ ] CHECK");
        JButton nextButton = new JButton("-->NEXT");


        // Show the first image from the images folder
        updateImage(imageLabel, animals.get(index[0]));



        //check button
        checkButton.addActionListener(event -> {
            //make the letter lowercase
            String input = inputField.getText().trim().toUpperCase();
            //get the current animal
            Animal current = animals.get(index[0]);

            // If input = the letter
            if (input.equals(current.getLetter())) {
                messageLabel.setText("Correct! '" + current.getLetter() + "' is for " + current.getName() + ".");
                messageLabel.setForeground(new Color(0, 255, 0)); // Green
                nextButton.setEnabled(true); // Enable NEXT
            } else {
                messageLabel.setText("Wrong! Try again.");
                messageLabel.setForeground(Color.RED); // Red
            }
        });



        //next button
        nextButton.addActionListener(e -> {
            //add the next animal
            index[0]++;
            if (index[0] < animals.size()) {
                // Update image
                updateImage(imageLabel, animals.get(index[0]));
                // Reset input and message
                inputField.setText("");
                messageLabel.setText("");
            }else  {
                index[0] = 0;
            }
        });



        //create a panel to put the image inside
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        //create panel to put the text input and the check button
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Type Letter:"));
        inputField.setFont(new Font("Roboto", Font.PLAIN, 18));
        inputPanel.add(inputField);
        inputPanel.add(checkButton);
        //create panel to add the messages
        JPanel messagePanel = new JPanel();
        messagePanel.add(messageLabel);
        //create panel to add the next button
        JPanel nextPanel = new JPanel();
        nextPanel.add(nextButton);

        //create the main panel to add everything
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        //Add everything to the main panel
        mainPanel.add(imagePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(messagePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(nextPanel);


        //add the panel to the mainframe of the app
        frame.add(mainPanel);
        //make the window size adjustable depending on the image
        frame.pack();
        frame.setVisible(true);
    }


    //change the image function
    private static void updateImage(JLabel label, Animal animal) {
        // Load image from the animal's folder
        ImageIcon icon = new ImageIcon(animal.getImagePath());
        Image img = icon.getImage();

        // Resize image
        int maxWidth = 300;
        int maxHeight = 250;

        // Set the new scaled image
        Image scaled = img.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaled));
    }
}
