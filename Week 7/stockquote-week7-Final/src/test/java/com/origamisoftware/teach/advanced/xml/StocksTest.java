package com.origamisoftware.teach.advanced.xml;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Stocks class.
 */
public class StocksTest {
    @Test
    public void getStock() throws Exception {
        Stocks stocks = ObjectFactory.createStockList();
        assertNotNull("Verify non-null object returned", stocks.getStock());
    }
}