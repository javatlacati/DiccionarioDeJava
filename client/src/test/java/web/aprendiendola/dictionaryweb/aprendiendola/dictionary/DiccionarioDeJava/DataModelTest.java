package web.aprendiendola.dictionaryweb.aprendiendola.dictionary.DiccionarioDeJava;

import static org.junit.Assert.assertEquals;

public class DataModelTest {

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * Test of canSearch method, of class DataModel.
     */
    @org.junit.Test
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
    @org.junit.Test
    public void testChangeFP() {
        System.out.println("changeFP");
        Dictionary model = new Dictionary();
        DataModel.changeFP(model);
    }

    /**
     * Test of changeSP method, of class DataModel.
     */
    @org.junit.Test
    public void testChangeSP() {
        System.out.println("changeSP");
        Dictionary model = new Dictionary();
        String data = "";
        DataModel.changeSP(model, data);
        
    }

}
