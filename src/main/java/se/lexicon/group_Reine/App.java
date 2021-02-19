package se.lexicon.group_Reine;


import se.lexicon.group_Reine.data.People;
import se.lexicon.group_Reine.data.PeopleImpl;
import se.lexicon.group_Reine.data.database.MySqlConnection;
import se.lexicon.group_Reine.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main( String[] args )
    {
        //Test connection to MySQL database
        /*Connection connection = MySqlConnection.getConnection();
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        //Test add person(s) to database
        People people = new PeopleImpl();
        Person person1 = people.create(new Person("Reine", "Moberg"));
        Person person2 = people.create(new Person("Anna", "Karlsson"));
        System.out.println(person1);
        System.out.println(person2);


    }
}
