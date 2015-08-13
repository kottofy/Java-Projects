/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.OrdersDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class OrdersDBTester
{

    public void testSelectAllOrders()
    {
        System.out.println("testSelectAllOrders()");
        OrdersDB ordersDB = new OrdersDB();
        ArrayList list = ordersDB.selectAllOrders();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("");
        }

    }

    public void testInsertOrders()
    {
        System.out.println("testInsertOrders()");
    }

    public void testUpdateOrders()
    {
        System.out.println("testUpdateOrders()");
    }

    public void testSelectFromOrders()
    {
        System.out.println("testSelectFromOrders()");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("OrdersDBTester");
        OrdersDBTester ordersDBTester = new OrdersDBTester();
        ordersDBTester.testSelectAllOrders();
        ordersDBTester.testInsertOrders();
        ordersDBTester.testUpdateOrders();
        ordersDBTester.testSelectFromOrders();
    }
}
