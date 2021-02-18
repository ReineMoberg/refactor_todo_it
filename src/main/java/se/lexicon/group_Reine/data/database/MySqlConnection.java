package se.lexicon.group_Reine.data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    //Connection information as constants
    private static final String URL = "jdbc:mysql://localhost:3306/todoit";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";

    //Establish connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("##### MySQL Connection is established #####");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
