package se.lexicon.group_Reine.data;

import se.lexicon.group_Reine.model.Person;
import se.lexicon.group_Reine.model.Todo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class People {

    private static Person[] persons = new Person[0];    //person object array created when program starts

    //return the number of people in, or length of, array
    public int size() {
        return Array.getLength(persons);
    }

    //return all people in the array
    public Person[] findAll() {
        return persons;
    }

    //return the person who has a certain id
    public Person findById(int personId) {
        Person foundPerson = new Person(personId);      //local variable with id parameter
        for (Person person : persons) {                 //search through person object array
            if (person.getPersonID() == personId) {
                foundPerson = person;                   //when person found, stop search
                break;
            }
        }
        return foundPerson;
    }

    //add person to array with a new id, then return the person that was added
    public Person addPerson(String firstName, String lastName) {
        Person personToAdd = new Person(PersonSequencer.nextPersonId(), firstName, lastName);
        Person[] newPersonArray = Arrays.copyOf(persons, persons.length + 1);
        newPersonArray[newPersonArray.length - 1] = personToAdd;
        persons = newPersonArray;
        return personToAdd;
    }

    //clear all persons in array
    public void clear() {
        persons = new Person[0];
    }

    //remove person from persons array by id
    public void removePerson(int personId) {
        Person[] newPersonArray = new Person[persons.length - 1];
        int findIndex = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getPersonID() == personId) {
                findIndex = i;
                break;
            }
        }
        int newArrayIndex = 0;
        for (int i = 0; i < persons.length; i++) {
            if (i == findIndex) {
                continue;
            }
            newPersonArray[newArrayIndex] = persons[i];
            newArrayIndex++;
        }
        persons = newPersonArray;
    }

}
