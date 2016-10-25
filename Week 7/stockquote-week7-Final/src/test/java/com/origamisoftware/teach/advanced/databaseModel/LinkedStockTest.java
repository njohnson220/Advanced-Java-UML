package com.origamisoftware.teach.advanced.databaseModel;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Tests for the LinkedStock class.
 */
public class LinkedStockTest {

    /**
     * Testing helper method for generating LinkedStock test data
     *
     * @return a LinkedStock object that uses Person and Symbol
     * return from their respective create method.
     */
    public static LinkedStock createLinkedStock() {
        Symbol symbol = SymbolTest.createSymbol();
        Person person = PersonTest.createPerson();
        return new LinkedStock(person, symbol);
    }

    @Test
    public void testLinkedStockGettersAndSetters() {
        Symbol symbol = SymbolTest.createSymbol();
        Person person = PersonTest.createPerson();
        LinkedStock linkedStock = new LinkedStock();
        int id = 5;
        linkedStock.setId(id);
        linkedStock.setPerson(person);
        linkedStock.setSymbol(symbol);
        assertEquals("Persons are equal", person, linkedStock.getPerson());
        assertEquals("Symbols are equal", symbol, linkedStock.getSymbol());
        assertEquals("Both id's are equal", id, linkedStock.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson() {
        LinkedStock linkedStock = createLinkedStock();
        linkedStock.setId(5);

        Person person = PersonTest.createPerson();
        Person otherPerson = new Person();
        Symbol symbol = SymbolTest.createSymbol();
        Timestamp birthdate = new Timestamp(person.getBirthDate().getTime() + 1000);

        otherPerson.setBirthDate(birthdate);
        otherPerson.setFirstName(person.getFirstName());
        otherPerson.setLastName(person.getLastName());

        LinkedStock otherLinkedStock = new LinkedStock(otherPerson, symbol);

        assertFalse("Different person", linkedStock.equals(otherLinkedStock));
    }
}