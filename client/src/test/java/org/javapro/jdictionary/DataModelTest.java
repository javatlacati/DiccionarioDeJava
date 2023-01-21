package org.javapro.jdictionary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataModelTest {

    /**
     * Test of canSearch method, of class DataModel.
     */
    @Test
    public void testCanSearch() {
        System.out.println("canSearch");
        String searchPhrase = "";
        final boolean expResult = false;
        final boolean result = DataModel.canSearch(searchPhrase);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeFP method, of class DataModel.
     */
    @Test
    public void testChangeFP() {
        System.out.println("changeFP");
        Dictionary model = new Dictionary();
        DataModel.changeFP(model);
    }

    /**
     * Test of changeSP method, of class DataModel.
     */
    @Test
    public void testChangeSP() {
        System.out.println("changeSP");
        Dictionary model = new Dictionary();
        String data = "";
        DataModel.changeSP(model, data);
        
    }

}
