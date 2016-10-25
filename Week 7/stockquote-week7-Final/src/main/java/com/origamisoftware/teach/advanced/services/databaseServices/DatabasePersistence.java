package com.origamisoftware.teach.advanced.services.databaseServices;

import com.origamisoftware.teach.advanced.databaseModel.Quote;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility for persisting objects to the database
 */
public class DatabasePersistence {

    public int addQuote(Quote quote) {

        SessionFactory sessionFactory = DatabaseUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        int quoteID = -1; //an impossible value for the ID to be should the method fail

        try{
            session.beginTransaction();
            quoteID = (int) session.save(quote);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            e.getStackTrace();
            session.getTransaction().rollback();
        }

        return quoteID;
    }

    public List<Integer> addQuote(List<Quote> quotes) {

        SessionFactory sessionFactory = DatabaseUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        List<Integer> persistedIDs = new ArrayList<>();
        int quoteID = -1; //an impossible value for the ID to be should the method fail

        try{
            session.beginTransaction();
            for (Quote quote : quotes) {
                persistedIDs.add((int) session.save(quote));
            }
            session.getTransaction().commit();

        }
        catch (HibernateException e) {
            e.getStackTrace();
            session.getTransaction().rollback();
        }

        return persistedIDs;
    }

}
