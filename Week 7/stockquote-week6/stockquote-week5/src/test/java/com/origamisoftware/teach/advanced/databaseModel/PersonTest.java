package com.origamisoftware.teach.advanced.databaseModel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static com.origamisoftware.teach.advanced.databaseModel.QuoteTest.price;
import static org.junit.Assert.*;

/**
 * Tests for the Person class.
 */
public class PersonTest {

    public static final String firstName = "John";
    public static final String lastName = "Smith";
    public static final Timestamp birthDate = new Timestamp(10000);

    /**
     * Testing helper method for generating Quote test data
     *
     * @return a Quote object that uses static constants for data.
     */
    public static Person createPerson() {
        Person testPerson = new Person();
        testPerson.setFirstName(firstName);
        testPerson.setLastName(lastName);
        testPerson.setBirthDate(birthDate);
        return testPerson;
    }

    @Test
    public void testPersonSettersAndGetters() {
        Person testPerson = createPerson();
        int id = 5;
        testPerson.setId(id);
        assertEquals("First Name", firstName, testPerson.getFirstName());
        assertEquals("Last Name", lastName, testPerson.getLastName());
        assertEquals("Birthday", birthDate, testPerson.getBirthDate());
        assertEquals("id", id, testPerson.getId());

    }
}