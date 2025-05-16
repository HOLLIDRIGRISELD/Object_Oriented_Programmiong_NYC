package Assesment_2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection conn;

    //data of the database user
    String URL = "jdbc:mysql://localhost:3306/hungman";
    String USERNAME = "hungman";
    String PASSWORD = "1234";

    //connect to the database
    public DatabaseManager() throws SQLException {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    // Register a new user
    public boolean register(String username, String password) throws SQLException {
        //try to isert the data to mysql
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO data(username, password, MatchPlayed, MatchWon) VALUES (?, ?, 0, 0)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        }
    }


    //login to user
    public User login(String username, String password) throws SQLException {
        //select the user formthe databse depending on the username and the password
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM data WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new User(rs.getString("username"), rs.getInt("MatchPlayed"), rs.getInt("MatchWon"));
        }
        return null;
    }


    //Update user score
    public void updateStats(String username, boolean won) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE data SET MatchPlayed = MatchPlayed + 1, MatchWon = MatchWon + ? WHERE username = ?");
        ps.setInt(1, won ? 1 : 0);
        ps.setString(2, username);
        ps.executeUpdate();
    }


    //gather the top 10 players
    public List<User> getTopUsers() throws SQLException {
        //create an array to put the users
        List<User> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        //run the query to get the users
        ResultSet rs = stmt.executeQuery("SELECT * FROM data ORDER BY MatchWon DESC LIMIT 10");

        //while loop to add the users to the array
        while (rs.next()) {
            list.add(new User(rs.getString("username"), rs.getInt("MatchPlayed"), rs.getInt("MatchWon")));
        }
        return list;
    }
}
