package com.origamisoftware.teach.advanced.xml;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ObjectFactory class.
 */
public class ObjectFactoryTest {

    @Test
    public void createStockList() throws Exception {
        assertNotNull("Verify factory created non-null object", ObjectFactory.createStockList());
    }

    @Test
    public void createSoloStock() throws Exception {
        assertNotNull("Verify factory created non-null object", ObjectFactory.createSoloStock());
    }

}