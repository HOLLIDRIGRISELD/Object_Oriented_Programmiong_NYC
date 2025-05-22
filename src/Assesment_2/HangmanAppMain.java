package Assesment_2;

import javax.swing.*;
import java.sql.SQLException;

public class HangmanAppMain {
    public static void main(String[] args) {
        try {
            DatabaseManager db = new DatabaseManager();
            new LoginWindow(db);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
