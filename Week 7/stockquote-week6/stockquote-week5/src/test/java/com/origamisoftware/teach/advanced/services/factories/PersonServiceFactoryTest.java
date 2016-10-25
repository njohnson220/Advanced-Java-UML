package com.origamisoftware.teach.advanced.services.factories;

import com.origamisoftware.teach.advanced.services.factories.PersonServiceFactory;
import com.origamisoftware.teach.advanced.services.interfaces.PersonService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathan on 10/16/2016.
 */
public class PersonServiceFactoryTest {

    @Test
    public void buildPersonService() throws Exception {
        PersonService service = PersonServiceFactory.DATABASE_PERSON.build();
        assertNotNull("Verify factory doesn't produce a null object", service);
    }



}