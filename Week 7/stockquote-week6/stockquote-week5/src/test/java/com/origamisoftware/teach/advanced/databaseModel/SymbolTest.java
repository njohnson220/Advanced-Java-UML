package com.origamisoftware.teach.advanced.databaseModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

/**
 * Tests for the Symbol class.
 */
public class SymbolTest {

    final static String symbol = "APPL";

    /**
     * Testing helper method for generating Symbol test data
     *
     * @return a Symbol object that uses static constants for data.
     */
    public static Symbol createSymbol() {
        Symbol testSymbol = new Symbol();
        testSymbol.setSymbol(symbol);
        return testSymbol;
    }

    @Test
    public void testSymbolSettersAndGetters() {
        Symbol testSymbol = createSymbol();
        int id = 5;
        testSymbol.setId(id);
        assertEquals("Symbol", symbol, testSymbol.getSymbol());
        assertEquals("id", id, testSymbol.getId());

    }
}