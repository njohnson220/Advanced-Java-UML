package com.origamisoftware.teach.advanced.services.factories;

import com.origamisoftware.teach.advanced.services.databaseServices.DatabaseQuoteService;
import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;

/**
 * Factory for creating QuoteServices
 */
public enum QuoteServiceFactory {
    DATABASE_QUOTE {
        /**
         * Builds a QuoteService for a database.
         * @return a DatabaseQuoteService.
         */
        public QuoteService build() { return new DatabaseQuoteService(); }
    };

    public abstract QuoteService build();
}
