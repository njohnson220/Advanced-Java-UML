package com.origamisoftware.teach.advanced.databaseModel;

import org.junit.Test;

import java.sql.Timestamp;

import static com.origamisoftware.teach.advanced.databaseModel.SymbolTest.createSymbol;
import static org.junit.Assert.*;

/**
 * Tests for the Quote class.
 */
public class QuoteTest {

    final static String symbol = "APPL";
    final static Timestamp time = new Timestamp(1000000);
    final static double price = 160.0;

    /**
     * Testing helper method for generating Quote test data
     *
     * @return a Quote object that uses static constants for data.
     */
    public static Quote createQuote() {
        Quote testQuote = new Quote();
        testQuote.setSymbol(symbol);
        testQuote.setPrice(price);
        testQuote.setTime(time);
        return testQuote;
    }

    @Test
    public void testQuoteSettersAndGetters() {
        Quote testQuote = createQuote();
        int id = 5;
        testQuote.setId(id);
        assertEquals("Symbol", symbol, testQuote.getSymbol());
        assertEquals("Price", price, testQuote.getPrice(), 1e-10);
        assertEquals("Time", time, testQuote.getTime());
        assertEquals("id", id, testQuote.getId());

    }

}