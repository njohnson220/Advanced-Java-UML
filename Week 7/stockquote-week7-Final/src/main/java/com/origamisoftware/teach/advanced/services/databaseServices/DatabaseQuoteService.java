package com.origamisoftware.teach.advanced.services.databaseServices;

import com.origamisoftware.teach.advanced.databaseModel.LinkedStock;
import com.origamisoftware.teach.advanced.databaseModel.Person;
import com.origamisoftware.teach.advanced.databaseModel.Quote;
import com.origamisoftware.teach.advanced.services.exceptions.PersonServiceException;
import com.origamisoftware.teach.advanced.services.exceptions.QuoteServiceException;
import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides services for retrieving Quotes from a database.
 */
public class DatabaseQuoteService implements QuoteService {

    /**
     * Get a list of all the quotes a person follows for all the symbols they follow.
     *
     * @return a list of stock instances
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Quote> getQuotes(Person person) throws QuoteServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        List<Quote> quotes = new ArrayList<>();
        List<String> symbols = getSymbols(person);

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Quote.class);
            criteria.add(Restrictions.in("symbol", symbols));

            quotes = criteria.list();
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
        return quotes;
    }

    /**
     * Get a list of all the quotes a person follows for all the symbols they follow.
     *
     * @return a list of stock instances
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Quote> getQuotes(Person person, DateTime start, DateTime end) throws QuoteServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        Timestamp startStamp = new Timestamp(start.getMillis());
        Timestamp endStamp = new Timestamp(end.getMillis());

        List<Quote> quotes = new ArrayList<>();
        List<String> symbols = getSymbols(person);

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Quote.class);
            criteria.add(Restrictions.in("symbol", symbols));
            criteria.add(Restrictions.between("time", startStamp, endStamp));

            quotes = criteria.list();
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
        return quotes;
    }

    /**
     * Get a list of all the quotes in the database
     *
     * @return a list of quote instances
     * @throws QuoteServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Quote> getQuotes() throws QuoteServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        List<Quote> quotes = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Quote.class);

            quotes = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        }
        return quotes;
    }

    /**
     * Get a list of all a person's followed stocks.
     *
     * @param person
     * @return a list of stock instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                or otherwise perform the requested operation.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<String> getSymbols(Person person) throws QuoteServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<String> symbols = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(LinkedStock.class);
            criteria.add(Restrictions.eq("person", person));

            List<LinkedStock> list = criteria.list();
            for (LinkedStock personStock : list) {
                symbols.add(personStock.getSymbol().getSymbol());
            }
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
        return symbols;

    }
}
