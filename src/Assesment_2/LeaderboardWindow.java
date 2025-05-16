package Assesment_2;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LeaderboardWindow extends JFrame {
    public LeaderboardWindow(DatabaseManager db) {
        setTitle("Top Players");
        setSize(400, 250);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        try {
            List<User> users = db.getTopUsers();
            String[][] data = new String[users.size()][3];
            String[] columns = {"USERNAME", "PLAYED", "WON"};

            for (int i = 0; i < users.size(); i++) {
                data[i][0] = users.get(i).getUsername();
                data[i][1] = String.valueOf(users.get(i).getMatchPlayed());
                data[i][2] = String.valueOf(users.get(i).getMatchWon());
            }

            JTable table = new JTable(data, columns);
            add(new JScrollPane(table), BorderLayout.CENTER);
            table.setEnabled(false);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}

