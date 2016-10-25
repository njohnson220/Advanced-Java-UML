package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.databaseModel.*;
import com.origamisoftware.teach.advanced.services.factories.QuoteServiceFactory;
import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the DatabaseQuoteService class.
 */
public class DatabaseQuoteServiceTest {

    private QuoteService quoteService;
    private Calendar birthDayCalendar = GregorianCalendar.getInstance();
    private Person person = new Person();
    private DateTime start;
    private DateTime end;


    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setUp() throws Exception {
        initDb();
        quoteService = QuoteServiceFactory.DATABASE_QUOTE.build();
        birthDayCalendar.setTimeInMillis(PersonTest.birthDate.getTime());
        person.setFirstName("Nathan");
        person.setLastName("Johnson");
        person.setBirthDate(Timestamp.valueOf("1999-01-14 00:00:01"));
        person.setId(1);

        start = new DateTime(2000, 1, 10, 0, 0, 1);
        end = new DateTime(2000, 2, 8, 0, 0, 1);
    }


    @Test
    public void getSymbolsForPerson() throws Exception {
        List<String> symbols = quoteService.getSymbols(person);
        assertFalse("Make sure there's some values in the list", symbols.isEmpty());
    }

    @Test
    public void getQuotesForPerson() throws Exception {
        List<Quote> quotes = quoteService.getQuotes(person);
        assertFalse("Make sure there's some values in the list", quotes.isEmpty());
    }

    @Test
    public void getQuotesBetweenTimes() throws Exception {
        Person testPerson = new Person();
        testPerson.setFirstName("John");
        testPerson.setLastName("Smith");
        testPerson.setId(1);
        testPerson.setBirthDate(Timestamp.valueOf("1967-07-04 00:00:01"));

        List<Quote> quotes = quoteService.getQuotes(testPerson, start, end);
        assertFalse("Make sure there's some values in the list", quotes.isEmpty());
    }

    @Test
    public void getAllQuotes() throws Exception {
        List<Quote> quotes = quoteService.getQuotes();
        assertFalse("Make sure there's some values in the list", quotes.isEmpty());
    }



}