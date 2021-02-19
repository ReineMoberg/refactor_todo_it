package se.lexicon.group_Reine;


import se.lexicon.group_Reine.data.People;
import se.lexicon.group_Reine.data.PeopleImpl;
import se.lexicon.group_Reine.data.TodoItems;
import se.lexicon.group_Reine.data.TodoItemsImpl;
import se.lexicon.group_Reine.data.database.MySqlConnection;
import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
        /*People people = new PeopleImpl();
        Person person3 = people.create(new Person("Reine", "Moberg"));
        Collection<Person> personCollection = people.findByName("Reine Moberg");
        personCollection.forEach(System.out::println);*/

        //Test update person
        /*People people = new PeopleImpl();
        Person person3 = people.update(new Person(3,"Reine", "Svensson"));
        System.out.println(person3);*/

        //Test delete person
        /*People people = new PeopleImpl();
        boolean result = people.deleteByiId(3);
        System.out.println(result);*/

        //Test add item(s) to database
        /*TodoItems todoItems = new TodoItemsImpl();
        Todo todo1 = todoItems.create(new Todo("Car", "Wash it", LocalDate.of(2021,3,1),false,1));
        Todo todo2 = todoItems.create(new Todo("Motorcycle", "Register it", LocalDate.of(2021,5,15),false,2));
        System.out.println(todo1);
        System.out.println(todo2);*/

        //Test retrieve all from todo_item table
        TodoItems todoItems = new TodoItemsImpl();
        Collection<Todo> todoCollection = todoItems.findAll();
        todoCollection.forEach(System.out::println);

    }
}
