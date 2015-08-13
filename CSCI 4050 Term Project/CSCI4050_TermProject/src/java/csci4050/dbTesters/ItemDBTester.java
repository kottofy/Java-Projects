/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.ItemDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class ItemDBTester
{

    public void testSelectAllItems()
    {
        ItemDB itemDB = new ItemDB();
        ArrayList list = itemDB.selectAllItems();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("");
        }
    }

    public void testInsertItem()
    {
        System.out.println("()");
    }

    public void testUpdateItem()
    {
        System.out.println("()");
    }

    public void testSelectFromItem()
    {
        System.out.println("()");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("ItemDBTester");
        ItemDBTester itemDBTester = new ItemDBTester();
        itemDBTester.testSelectAllItems();
        itemDBTester.testInsertItem();
        itemDBTester.testUpdateItem();
        itemDBTester.testSelectFromItem();
    }
}
