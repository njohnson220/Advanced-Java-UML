package com.origamisoftware.teach.advanced.services.interfaces;

import com.origamisoftware.teach.advanced.databaseModel.Person;
import com.origamisoftware.teach.advanced.databaseModel.Quote;
import com.origamisoftware.teach.advanced.services.exceptions.PersonServiceException;
import com.origamisoftware.teach.advanced.services.exceptions.QuoteServiceException;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Models a PersonService
 */
public interface QuoteService {

    /**
     * Get a list of all the quotes a person follows for all the symbols they follow.
     *
     * @return a list of quote instances
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    List<Quote> getQuotes(Person person) throws QuoteServiceException;

    /**
     * Get a list of all the quotes a person follows between a start and end time
     *
     * @param person a Person object
     * @param start the start time
     * @param end the end time
     * @return A list of Quotes
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    List<Quote> getQuotes(Person person, DateTime start, DateTime end) throws QuoteServiceException;

    /**
     * Get a list of all the quotes in the database
     *
     * @return a list of quote instances
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    List<Quote> getQuotes() throws QuoteServiceException;

    /**
     * Get a list of all a person's followed stocks.
     *
     * @return a list of strings
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    public List<String> getSymbols(Person person) throws QuoteServiceException;

}
