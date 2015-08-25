package acme;

import junit.framework.TestCase;

/**
 *
 * @author kottofy
 */
public class LineItemTest extends TestCase {

    public LineItemTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testConstructor()
    {
        System.out.println("constructor");
        LineItem instance = new LineItem(4, 2);
        assertEquals(4, instance.getItemID());
        assertEquals(2, instance.getQuantity());
        assertEquals("Batman Outfit", instance.getDescription());
    }
}
