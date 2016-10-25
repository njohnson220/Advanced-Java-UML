package com.origamisoftware.teach.advanced.application;

import com.origamisoftware.teach.advanced.databaseModel.Quote;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the XMLDataParser class.
 */
public class XMLDataParserTest {

    @Test
    public void parseXMLData() throws Exception {
        List<Quote> quotes;
        XMLDataParser dataAdder = new XMLDataParser();

        quotes = dataAdder.parseXMLData("./src/main/resources/xml/stock_info.xml");

        Assert.assertNotNull("Ensure values were retrieved", quotes);
    }


}