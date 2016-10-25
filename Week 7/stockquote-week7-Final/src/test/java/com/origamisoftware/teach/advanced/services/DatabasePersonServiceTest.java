package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.databaseModel.*;
import com.origamisoftware.teach.advanced.services.exceptions.PersonServiceException;
import com.origamisoftware.teach.advanced.services.factories.PersonServiceFactory;
import com.origamisoftware.teach.advanced.services.factories.QuoteServiceFactory;
import com.origamisoftware.teach.advanced.services.interfaces.PersonService;
import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the DatabasePersonService class.
 */
public class DatabasePersonServiceTest {

    private PersonService personService;
    private QuoteService quoteService;
    private Calendar birthDayCalendar = GregorianCalendar.getInstance();
    private Person person = new Person();


    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setUp() throws Exception {
        initDb();
        quoteService = QuoteServiceFactory.DATABASE_QUOTE.build();
        personService = PersonServiceFactory.DATABASE_PERSON.build();
        birthDayCalendar.setTimeInMillis(PersonTest.birthDate.getTime());
        person.setFirstName("Nathan");
        person.setLastName("Johnson");
        person.setBirthDate(Timestamp.valueOf("1999-01-14 00:00:01"));
        person.setId(1);
    }

    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void getInstance() {
        assertNotNull("Make sure personService is available", personService);
    }

    @Test
    public void getPerson() throws PersonServiceException {
        List<Person> personList = personService.getPerson();
        assertFalse("Make sure there's some values in the list", personList.isEmpty());

    }

    @Test
    public void addOrUpdatePerson() throws Exception {
        Person newPerson = PersonTest.createPerson();
        personService.addOrUpdatePerson(newPerson);
        List<Person> personList = personService.getPerson();
        boolean found = false;
        for (Person person : personList) {
            Timestamp returnedBirthDate = person.getBirthDate();
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
            if (returnCalendar.get(Calendar.MONTH) == birthDayCalendar.get(Calendar.MONTH)
                    &&
                    returnCalendar.get(Calendar.YEAR) == birthDayCalendar.get(Calendar.YEAR)
                    &&
                    returnCalendar.get(Calendar.DAY_OF_MONTH) == birthDayCalendar.get(Calendar.DAY_OF_MONTH)
                    &&
                    person.getLastName().equals(PersonTest.lastName)
                    &&
                    person.getFirstName().equals(PersonTest.firstName)) {
                found = true;
                break;
            }
        }
        assertTrue("Verify found data", found);
    }

    @Test
    public void addSymbolToPerson() throws Exception {
        Symbol testSymbol = SymbolTest.createSymbol();
        personService.addSymbolToPerson(testSymbol, person);
        List<String> symbolList = quoteService.getSymbols(person);
        assertTrue("Verify newly added symbol was actually added", symbolList.contains(testSymbol.getSymbol()));
    }
}