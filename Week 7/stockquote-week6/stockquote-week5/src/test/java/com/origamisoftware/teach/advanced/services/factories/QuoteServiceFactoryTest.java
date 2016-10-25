package com.origamisoftware.teach.advanced.services.factories;

import com.origamisoftware.teach.advanced.services.interfaces.QuoteService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathan on 10/22/2016.
 */
public class QuoteServiceFactoryTest {

    @Test
    public void build() throws Exception {
        QuoteService service = QuoteServiceFactory.DATABASE_QUOTE.build();
        assertNotNull("Verify factory doesn't produce a null object", service);
    }

}