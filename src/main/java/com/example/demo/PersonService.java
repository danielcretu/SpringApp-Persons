package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PersonService {
    private static HashMap<Integer, Person> persons = new HashMap<>();
    private static int index = 2;

    static {
        Person person = new Person(0, "Daniel", 25);
        Person person1 = new Person(1, "Andreea", 27);
        Person person2 = new Person(2, "Marian", 33);
        persons.put(0, person);
        persons.put(1, person1);
        persons.put(2, person2);
    }

    public static List<Person> getAllPersons() {
        return new ArrayList<>(persons.values());
    }

    public static Person getPersonDetails(int id) {
        return persons.get(id);
    }

    public static Person addPerson(Person person) {
        index += 1;
        person.setId(index);
        persons.put(index, person);
        return person;
    }

    public static Person updatePerson(int id, Person person) {
        person.setId(id);
        persons.put(id, person);
        return person;
    }

    public static Person deletePerson(int id) {
        return persons.remove(id);
    }
}
