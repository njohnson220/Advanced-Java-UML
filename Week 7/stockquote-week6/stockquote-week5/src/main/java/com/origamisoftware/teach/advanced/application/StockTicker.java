package com.origamisoftware.teach.advanced.application;

import com.origamisoftware.teach.advanced.databaseModel.Person;
import com.origamisoftware.teach.advanced.databaseModel.Quote;
import com.origamisoftware.teach.advanced.services.databaseServices.DatabasePersistence;
import com.origamisoftware.teach.advanced.services.exceptions.QuoteServiceException;
import com.origamisoftware.teach.advanced.services.factories.QuoteServiceFactory;
import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.List;

/**
 * A simple stock ticker application that takes a few arguments and returns found stocks
 */
public class StockTicker {

    private static DatabasePersistence persistence = new DatabasePersistence();
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static QuoteService quoteService = QuoteServiceFactory.DATABASE_QUOTE.build();
    private static XMLDataParser parser = new XMLDataParser();
    private static Person person = new Person();

    private static DateTime dateParser(String unformattedDate) {
        return formatter.parseDateTime(unformattedDate);
    }

    public static void main(String[] args) throws Exception {

        //My recommended program arguments for the data I've entered:
        //John Smith 1967-07-04 00:00:01 2000-01-08 00:00:01 2000-02-10 00:00:01

        if(args.length != 8) {
            throw new Exception("Input arguments must be in the format: FIRST_NAME LAST_NAME BIRTHDATE(yyyy-MM-dd) " +
                                "BIRTHTIME(HH:mm:ss) START_DATE(yyyy-MM-dd) " + "START_TIME(HH:mm:ss) END_DATE(yyyy-MM-dd) END_TIME(HH:mm:ss)");
        }

        //Adds the quotes from the XML file into the database using JAXB and the ORM.
        List<Quote> parsedQuotes = parser.parseXMLData("./src/main/resources/xml/stock_info.xml");
        persistence.addQuote(parsedQuotes);

        person.setFirstName(args[0]);
        person.setLastName(args[1]);
        person.setBirthDate(Timestamp.valueOf(args[2] + " " + args[3]));

        //Right now, I'm kind of confused as to how to search for an object in the
        //database without knowing that object's ID. An ID of 1 corresponds to Person
        //John Smith, so I needed to enter that here. If you could elaborate on this,
        //I'd greatly appreciate it. An ID of 2 corresponds to Nathan Johnson, an ID of 3
        //corresponds to Abraham Lincoln, and an ID of 4 corresponds to John Kennedy.
        person.setId(1);

        DateTime start = dateParser(args[4] + " " + args[5]);
        DateTime end = dateParser(args[6] + " " + args[7]);

        List<Quote> quotes;

        try {
            quotes = quoteService.getQuotes(person, start, end);
        }
        catch (QuoteServiceException e) {
            throw new QuoteServiceException("Unable to read quotes", e);
        }

        System.out.println("\nQuotes for: " + args[0] + " " + args[1]);

        if(quotes.isEmpty()) {
            System.out.println("No quotes found for that person.");
        }

        for (Quote quote : quotes) {
            System.out.println(quote.toString());
        }
    }
}
