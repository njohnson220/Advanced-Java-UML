package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.databaseModel.PersonTest;
import com.origamisoftware.teach.advanced.databaseModel.Quote;
import com.origamisoftware.teach.advanced.services.databaseServices.DatabasePersistence;
import com.origamisoftware.teach.advanced.services.factories.QuoteServiceFactory;
import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the DatabasePersistence class.
 */
public class DatabasePersistenceTest {

    private QuoteService quoteService = QuoteServiceFactory.DATABASE_QUOTE.build();
    private Calendar birthDayCalendar = GregorianCalendar.getInstance();
    private Quote quote = new Quote();
    private Quote quote2 = new Quote();
    private Quote quote3 = new Quote();
    private List<Quote> quoteList = new ArrayList<>();

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setUp() throws Exception {
        initDb();
        birthDayCalendar.setTimeInMillis(PersonTest.birthDate.getTime());
        quote.setTime(Timestamp.valueOf("1996-01-14 00:00:01"));
        quote.setPrice(543.21);
        quote.setSymbol("BLAH");

        quote2.setTime(Timestamp.valueOf("1994-01-14 00:00:01"));
        quote2.setPrice(123.45);
        quote2.setSymbol("HAHA");

        quote3.setTime(Timestamp.valueOf("1995-01-14 00:00:01"));
        quote3.setPrice(226.85);
        quote3.setSymbol("HAHA");

        quoteList.add(quote);
        quoteList.add(quote2);
        quoteList.add(quote3);

    }

    @Test
    public void addQuote() throws Exception {
        DatabasePersistence persistence = new DatabasePersistence();
        int persistedID = persistence.addQuote(quote);
        quote.setId(persistedID);
        List<Quote> quotes = quoteService.getQuotes();
        assertTrue("Verify quote was added", quotes.contains(quote));
    }


    @Test
    public void addQuoteList() throws Exception {
        DatabasePersistence persistence = new DatabasePersistence();
        List<Integer> persistedIDs = persistence.addQuote(quoteList);

        quoteList.get(0).setId(persistedIDs.get(0));
        quoteList.get(1).setId(persistedIDs.get(1));
        quoteList.get(2).setId(persistedIDs.get(2));

        List<Quote> quotes = quoteService.getQuotes();
        assertTrue("Verify quote was added", quotes.containsAll(quoteList));
    }

}