package se.lexicon.group_Reine;


import se.lexicon.group_Reine.data.database.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main( String[] args )
    {
        //Test connection to MySQL database
        Connection connection = MySqlConnection.getConnection();
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
