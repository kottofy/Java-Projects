/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acme;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author kottofy
 */
public class ShoppingCartBeanTest extends TestCase {



    public void testConstructor()
    {
        System.out.println("constructor");
        ArrayList instance = new ArrayList();
     //   ArrayList result = instance.getCart();
        LineItem temp;

        testGetCart();

        testSetItemID();
        testSetQuantity();


 }

    public ShoppingCartBeanTest(String testName) {
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

    /**
     * Test of getCart method, of class ShoppingCartBean.
     */
    public void testGetCart() {
        System.out.println("getCart");
        ShoppingCartBean instance = new ShoppingCartBean();
        ArrayList expResult = null;
        ArrayList result = instance.getCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  //      fail("The test case is a prototype.");
    }

    /**
     * Test of setItemID method, of class ShoppingCartBean.
     */
    public void testSetItemID() {
        System.out.println("setItemID");
        int itemID = 0;
        ShoppingCartBean instance = new ShoppingCartBean();
        instance.setItemID(itemID);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class ShoppingCartBean.
     */
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        int itemID = 0;
        ShoppingCartBean instance = new ShoppingCartBean();
        instance.getCart();
        instance.setItemID(itemID);
        instance.setQuantity(quantity);
        System.out.println(instance.getCart());

        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

}
