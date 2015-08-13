/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.LineItemDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class LineItemDBTester
{

    public void testSelectAllLineItems()
    {
        System.out.println("testSelectAllLineItems()");
        LineItemDB lineItemDB = new LineItemDB();
        ArrayList list = lineItemDB.selectAllLineItems();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("");
        }

    }

    public void testInsertLineItem()
    {
        System.out.println("testInsertLineItem()");
    }

    public void testUpdateLineItem()
    {
        System.out.println("testUpdateLineItem()");
    }

    public void testSelectFromLineItem()
    {
        System.out.println("testSelectFromLineItem()");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("LineItemDBTester");
        LineItemDBTester lineItemDBTester = new LineItemDBTester();
        lineItemDBTester.testSelectAllLineItems();
        lineItemDBTester.testInsertLineItem();
        lineItemDBTester.testUpdateLineItem();
        lineItemDBTester.testSelectFromLineItem();

    }
}
