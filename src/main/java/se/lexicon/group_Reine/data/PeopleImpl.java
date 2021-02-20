package se.lexicon.group_Reine.data;


import se.lexicon.group_Reine.data.database.MySqlConnection;
import se.lexicon.group_Reine.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PeopleImpl implements People{

    /*Add a person to database. Person id gets generated by database and added to object
     * */
    @Override
    public Person create(Person person) {
        String query = "insert into person (first_name, last_name) values (?,?)";
        int retrievedId;
        try (
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    retrievedId = resultSet.getInt(1);
                    person.setPersonID(retrievedId);
                }
            } else {
                System.out.println("No person ID retrieved from database");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    /*Find all person information from database
     * */
    @Override
    public Collection<Person> findAll() {
        String query = "select * from person";
        Collection<Person> personCollection = new ArrayList<>();
        try (
                Statement statement = MySqlConnection.getConnection().createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                personCollection.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personCollection;
    }

    /*Find person information by id from database
     * */
    @Override
    public Person findById(int id) {
        String query = "select * from person where person_id = ?";
        Person person = new Person();
        try(
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                person.setPersonID(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    /*Find person information by name from database
     * */
    @Override
    public Collection<Person> findByName(String name) {
        String[] fullName = name.trim().split("\\s+");
        String firstName = fullName[0];
        String[] lastNames = Arrays.copyOfRange(fullName, 1, fullName.length);
        String lastName = String.join(" ", lastNames);
        String query = "select * from person where first_name = ? and last_name = ?";
        Collection<Person> personCollection = new ArrayList<>();
        try (
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personCollection.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personCollection;
    }

    /*Update a person based on id. All columns except id
     * */
    @Override
    public Person update(Person person) {
        String query = "update person set first_name = ?, last_name = ? where person_id = ?";
        try (
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getPersonID());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    /*Delete a person based on id
     * */
    @Override
    public boolean deleteByiId(int id) {
        boolean deleteSuccess = false;
        int rowsAffected;
        String query = "delete from person where person_id = ?";
        try (
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                deleteSuccess = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleteSuccess;
    }

}
