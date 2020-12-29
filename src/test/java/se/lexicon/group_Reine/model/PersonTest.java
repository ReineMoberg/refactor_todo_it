package se.lexicon.group_Reine.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class PersonTest {

    private Person testPerson;      //create object from Person class

    //initialize objects constructor
    @Before
    public void setup(){
        testPerson = new Person(691126,"Reine","Moberg");
    }

    //testing methods
    @Test
    public void testGetPersonID() {
        int expectedID = 691126;
        Assert.assertTrue(expectedID == testPerson.getPersonID());
    }

    @Test
    public void testGetFirstName() {
        String expectedFirstName = "Reine";
        Assert.assertTrue(expectedFirstName.equalsIgnoreCase(testPerson.getFirstName()));
    }

    @Test
    public void testGetLastName() {
        String expectedLastName = "Moberg";
        Assert.assertTrue(expectedLastName.equalsIgnoreCase(testPerson.getLastName()));
    }

    @Test
    public void testSetFirstName() {
        String expectedFirstName = "Lars";
        testPerson.setFirstName("Lars");
        Assert.assertTrue(expectedFirstName.equalsIgnoreCase(testPerson.getFirstName()));
    }

    @Test
    public void testSetLastName() {
        String expectedLastName ="Olsson";
        testPerson.setLastName("Olsson");
        Assert.assertTrue(expectedLastName.equalsIgnoreCase(testPerson.getLastName()));
    }

}
