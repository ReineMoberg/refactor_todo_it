package se.lexicon.group_Reine.model;

public class Person {

    //object specific variables
    private final int personID;     //can only be initialized once
    private String firstName;
    private String lastName;

    //constructor 1
    public Person(int personID) {
        this.personID = personID;
    }

    //constructor 2
    public Person(int personID, String firstName, String lastName) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //setters ang getters
    public int getPersonID() {
        return personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
