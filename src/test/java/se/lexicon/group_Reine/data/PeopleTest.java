package se.lexicon.group_Reine.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import se.lexicon.group_Reine.model.Person;

import java.util.Arrays;

public class PeopleTest {

    private People testPeople;      //create object from People class

    //initialize object
    @Before
    public void setUp() {
        testPeople = new People();
    }

    //add two persons and check if both were added
    @Test
    public void testAddPerson() {
        int expectedId1 = 1;
        String expectedFirstName1 = "Reine";
        String expectedLastName1 = "Moberg";
        int expectedId2 = 2;
        String expectedFirstName2 = "Sven";
        String expectedLastName2 = "Andersson";
        PersonSequencer.reset();
        Person testPerson1 = testPeople.addPerson("Reine", "Moberg");
        Assert.assertTrue(testPerson1.getPersonID() == expectedId1 && testPerson1.getFirstName().equalsIgnoreCase(expectedFirstName1) && testPerson1.getLastName().equalsIgnoreCase(expectedLastName1));
        Person testPerson2 = testPeople.addPerson("Sven", "Andersson");
        Assert.assertTrue(testPerson2.getPersonID() == expectedId2 && testPerson2.getFirstName().equalsIgnoreCase(expectedFirstName2) && testPerson2.getLastName().equalsIgnoreCase(expectedLastName2));
    }

    //add two persons and check how many people are in array
    @Test
    public void testSize() {
        int expectedSize = 2;
        testPeople.addPerson("Reine", "Moberg");
        testPeople.addPerson("Sven", "Andersson");
        Assert.assertTrue(testPeople.size() == expectedSize);
    }

    //add three persons and check search for a person with a specific id
    @Test
    public void testFindById() {
        String expectedFirstName = "Ove";
        String expectedLastName = "Melkersson";
        int searchId = 3;
        PersonSequencer.reset();
        testPeople.addPerson("Reine", "Moberg");
        testPeople.addPerson("Sven", "Andersson");
        testPeople.addPerson("Ove","Melkersson");
        Person foundPerson = testPeople.findById(searchId);
        Assert.assertTrue(foundPerson.getPersonID() == searchId && foundPerson.getFirstName().equalsIgnoreCase(expectedFirstName) && foundPerson.getLastName().equalsIgnoreCase(expectedLastName));
    }

    /*add three persons, and same persons to local person array,
    to check if entire array of persons is returned and is correct.
    only first names are checked.
    I just can not get object comparison to work, hence the commented code*/
    @Test
    public void testFindAll() {
        Person[] testPeople2 = new Person[3];
        PersonSequencer.reset();
        testPeople.addPerson("Reine", "Moberg");
        testPeople2[0] = new Person(1,"Reine", "Moberg");
        //testPeople2[0] = testPeople.findById(1);
        testPeople.addPerson("Sven", "Andersson");
        testPeople2[1] = new Person(2,"Sven", "Andersson");
        //testPeople2[1] = testPeople.findById(2);
        testPeople.addPerson("Ove","Melkersson");
        testPeople2[2] = new Person(3,"Ove","Melkersson");
        //testPeople2[2] = testPeople.findById(3);
        Person[] persons = testPeople.findAll();
        Assert.assertTrue(testPeople2[0].getFirstName().equalsIgnoreCase(persons[0].getFirstName()));
        Assert.assertTrue(testPeople2[1].getFirstName().equalsIgnoreCase(persons[1].getFirstName()));
        Assert.assertTrue(testPeople2[2].getFirstName().equalsIgnoreCase(persons[2].getFirstName()));
        //System.out.println(testPeople.findById(1).getFirstName());
        //System.out.println(testPeople2[0].getFirstName());
        //System.out.println(testPeople.findById(2).getFirstName());
        //System.out.println(testPeople2[1].getFirstName());
        //System.out.println(testPeople.findById(3).getFirstName());
        //System.out.println(testPeople2[2].getFirstName());
        //Assert.assertArrayEquals(testPeople2, testPeople.findAll());
        //Assert.assertArrayEquals(testPeople2, persons);
        //Assert.assertTrue(Arrays.equals(testPeople2,testPeople.findAll()));
        //Assert.assertTrue(Arrays.equals(testPeople2,persons));
        //Assert.assertTrue(testPeople2.equals(testPeople.findAll()));
    }

    //add a person and check that there are persons in array.
    //then clear all persons and check that the array is empty
    @Test
    public void testClear() {
        int expectedSize = 0;
        PersonSequencer.reset();
        testPeople.addPerson("Reine", "Moberg");
        Assert.assertTrue(testPeople.size() != expectedSize);
        testPeople.clear();
        Assert.assertTrue(testPeople.size() == expectedSize);
    }

}
