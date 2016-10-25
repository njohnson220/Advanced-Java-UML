package com.origamisoftware.teach.advanced.services.factories;

import com.origamisoftware.teach.advanced.services.databaseServices.DatabasePersonService;
import com.origamisoftware.teach.advanced.services.interfaces.PersonService;

/**
 * Factory for creating PersonServices
 */
public enum PersonServiceFactory {
    DATABASE_PERSON {
        /**
         * Builds a PersonService for a database.
         * @return a DatabasePersonService.
         */
        public PersonService build() { return new DatabasePersonService(); }
    };

    public abstract PersonService build();

}
