package com.origamisoftware.teach.advanced.application;

import com.origamisoftware.teach.advanced.databaseModel.Quote;
import com.origamisoftware.teach.advanced.xml.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses XML data from the given file into a List of Quotes
 */
class XMLDataParser {

    /**
     * Parses the data contained within an XML file into a List of Quote objects.
     *
     * @param filePath The path to the specified XML file.
     * @return A list of Quotes.
     * @throws JAXBException if unable to read the data from the XML file.
     */
    List<Quote> parseXMLData(String filePath) throws JAXBException {

        Stocks stocks;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            stocks = (Stocks) unmarshaller.unmarshal(new File(filePath));
        }
        catch (JAXBException e) {
            throw new JAXBException("Unable to parse XML File", e);
        }

        List<Stocks.Stock> stockList = stocks.getStock();
        List<Quote> quotesORM = new ArrayList<>();
        
        for (Stocks.Stock stock : stockList) {
            Quote quoteORM = new Quote();

            quoteORM.setSymbol(stock.getSymbol());
            quoteORM.setTime(Timestamp.valueOf(stock.getTime()));
            quoteORM.setPrice(Double.parseDouble(stock.getPrice()));
            
            quotesORM.add(quoteORM);
        }

        return quotesORM;
    }
}
