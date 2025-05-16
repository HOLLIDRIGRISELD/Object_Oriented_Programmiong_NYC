package Assesment_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class LoginWindow extends JFrame {
    private DatabaseManager db;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton registerBtn;

    //constructor to make the db variable usable
    public LoginWindow(DatabaseManager db) {
        this.db = db;

        //main wind for the login or registration
        setTitle("LOGIN FRAME");
        setSize(400, 250);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //create the needed components
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginBtn = new JButton("LOGIN");
        registerBtn = new JButton("REGISTER");

        //add the action to the buttons
        loginBtn.addActionListener(new LoginHandler());
        registerBtn.addActionListener(new RegisterHandler());


        //create the login window
        add(new JLabel("USERNAME:"));
        add(usernameField);
        add(new JLabel("PASSWORD:"));
        add(passwordField);
        add(loginBtn);
        add(registerBtn);
        //make the window visible
        setVisible(true);
    }

    //try to login
    class LoginHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //try to login the current username and password
            try {
                User user = db.login(usernameField.getText(), new String(passwordField.getPassword()));
                //check is the login was successful
                if (user != null) {
                    new GameWindow(user, db);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this, "WRONG USERNAME OR PASSWORD!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    //register new user
    class RegisterHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //try to register
            try {
                boolean success = db.register(usernameField.getText(), new String(passwordField.getPassword()));
                //if the register was successful
                if (success) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "REGISTERED!");
                }
                else {
                    JOptionPane.showMessageDialog(LoginWindow.this, "USERNAME EXISTS!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

