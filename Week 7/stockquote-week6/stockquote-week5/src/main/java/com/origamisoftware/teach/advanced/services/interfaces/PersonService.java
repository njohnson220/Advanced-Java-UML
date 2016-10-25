package com.origamisoftware.teach.advanced.services.interfaces;


import com.origamisoftware.teach.advanced.databaseModel.Person;
import com.origamisoftware.teach.advanced.databaseModel.Symbol;
import com.origamisoftware.teach.advanced.services.exceptions.PersonServiceException;

import java.util.List;

/**
 * Models a PersonService.
 */
public interface PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Person> getPerson() throws PersonServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdatePerson(Person person) throws PersonServiceException;

    /**
     * Assign a stock to a person.
     *
     * @param symbol  The stock to assign
     * @param person The person to assign the quote too.
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addSymbolToPerson(Symbol symbol, Person person) throws PersonServiceException;

}
