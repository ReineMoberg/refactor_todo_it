package se.lexicon.group_Reine;


import se.lexicon.group_Reine.data.People;
import se.lexicon.group_Reine.data.PeopleImpl;
import se.lexicon.group_Reine.data.database.MySqlConnection;
import se.lexicon.group_Reine.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

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
        /*People people = new PeopleImpl();
        Person person1 = people.create(new Person("Reine", "Moberg"));
        Person person2 = people.create(new Person("Anna", "Karlsson"));
        System.out.println(person1);
        System.out.println(person2);*/

        //Test retrieve all from person table
        /*People people = new PeopleImpl();
        Collection<Person> personCollection = people.findAll();
        personCollection.forEach(System.out::println);*/

        //Test retrieve person by ID
        /*People people = new PeopleImpl();
        Person person1 = people.findById(1);
        Person person2 = people.findById(2);
        System.out.println(person1);
        System.out.println(person2);*/

        //Test retrieve person by name
        People people = new PeopleImpl();
        Person person3 = people.create(new Person("Reine", "Moberg"));
        Collection<Person> personCollection = people.findByName("Reine Moberg");
        personCollection.forEach(System.out::println);

    }
}
