package com.origamisoftware.teach.advanced.services.databaseServices;

import com.origamisoftware.teach.advanced.databaseModel.LinkedStock;
import com.origamisoftware.teach.advanced.databaseModel.Person;
import com.origamisoftware.teach.advanced.databaseModel.Symbol;
import com.origamisoftware.teach.advanced.services.exceptions.PersonServiceException;
import com.origamisoftware.teach.advanced.services.interfaces.PersonService;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Models a service to grab Person data from a database.
 */
public class DatabasePersonService implements PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPerson() throws PersonServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;
    }

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    public void addOrUpdatePerson(Person person) throws PersonServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }





    /**
     * Assign a symbol to a person.
     *
     * @param symbol
     * @param person The person to assign the hobby too.
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    public void addSymbolToPerson(Symbol symbol, Person person) throws PersonServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            LinkedStock linkedStock = new LinkedStock();
            linkedStock.setSymbol(symbol);
            linkedStock.setPerson(person);
            session.saveOrUpdate(linkedStock);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
}
