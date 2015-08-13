/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.CategoryDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class CategoryDBTester
{

    public void testSelectAllCategories()
    {
        System.out.println("testSelectAllCategories()");
        CategoryDB catDB = new CategoryDB();
        ArrayList list = catDB.selectAllCategories();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println();
        }

    }

    public void testInsertCategory()
    {
        System.out.println("testInsertCategory()");
    }

    public void testUpdateCategory()
    {
        System.out.println("testUpdateCategory()");
    }

    public void testSelectFromCategory()
    {
        System.out.println("testSelectFromCategory()");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("CategoryDBTester");
        CategoryDBTester categoryDBTester = new CategoryDBTester();
        categoryDBTester.testSelectAllCategories();
        categoryDBTester.testInsertCategory();
        categoryDBTester.testUpdateCategory();
        categoryDBTester.testSelectFromCategory();

    }
}
