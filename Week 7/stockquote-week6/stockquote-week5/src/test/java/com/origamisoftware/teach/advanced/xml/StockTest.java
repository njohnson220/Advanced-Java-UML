package com.origamisoftware.teach.advanced.xml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Stock class.
 */
public class StockTest {

    private Stocks.Stock stock = ObjectFactory.createSoloStock();
    private String symbol = "BLAH";
    private String price = "123.45";
    private String time = "2000-01-12 00:00:01";

    @Before
    public void setUp() {
        stock.setSymbol(symbol);
        stock.setPrice(price);
        stock.setTime(time);
    }

    @Test
    public void getSymbol() throws Exception {
        assertEquals("Symbol", symbol, stock.getSymbol());
    }


    @Test
    public void setSymbol() throws Exception {
        Stocks.Stock stock = ObjectFactory.createSoloStock();
        String testSymbol = "HAHA";

        stock.setSymbol(testSymbol);
        assertEquals("Symbol", testSymbol, stock.getSymbol());

    }

    @Test
    public void getPrice() throws Exception {
        assertEquals("Price", price, stock.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        Stocks.Stock stock = ObjectFactory.createSoloStock();
        String testPrice = "123";

        stock.setPrice(testPrice);
        assertEquals("Symbol", testPrice, stock.getPrice());
    }

    @Test
    public void getTime() throws Exception {
        assertEquals("Time", time, stock.getTime());
    }

    @Test
    public void setTime() throws Exception {
        Stocks.Stock stock = ObjectFactory.createSoloStock();
        String testTime = "123";

        stock.setTime(testTime);
        assertEquals("Time", testTime, stock.getTime());
    }

}