package se.lexicon.group_Reine.data;

import se.lexicon.group_Reine.model.Person;

import java.util.Collection;

public interface People {

    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteByiId(int id);

}
