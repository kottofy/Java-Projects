/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.ItemAttributesDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class ItemAttributesDBTester
{

    public void testSelectAllItemAttributes()
    {
        System.out.println("testSelectAllItemAttributes()");
        ItemAttributesDB itemAttrDB = new ItemAttributesDB();
        ArrayList list = itemAttrDB.selectAllItemAttributes();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("");
        }

    }

    public void testInsertItemAttributes()
    {
        System.out.println("testInsertItemAttributes()");
    }

    public void testUpdateItemAttributes()
    {
        System.out.println("testUpdateItemAttributes()");
    }

    public void testSelectFromItemAttributes()
    {
        System.out.println("testSelectFromItemAttributes()");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("ItemAttributesDBTester");
        ItemAttributesDBTester itemAttributesDBTester = new ItemAttributesDBTester();
        itemAttributesDBTester.testSelectAllItemAttributes();
        itemAttributesDBTester.testInsertItemAttributes();
        itemAttributesDBTester.testUpdateItemAttributes();
        itemAttributesDBTester.testSelectFromItemAttributes();
    }
}
