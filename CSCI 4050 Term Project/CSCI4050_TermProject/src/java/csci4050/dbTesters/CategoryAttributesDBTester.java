/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.CategoryAttributesDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class CategoryAttributesDBTester
{

    public void testselectAllCategoryAttributes()
    {
        System.out.println("testselectAllCategoryAttributes()");
        
        CategoryAttributesDB catAttrDB = new CategoryAttributesDB();
        ArrayList list = catAttrDB.selectAllCategoryAttributes();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println();
        }
    }
    
    public void testInsertCategoryAttribute()
    {
        System.out.println("testInsertCategoryAttribute()");
    }
    
    public void testUpdateCategoryAttribute()
    {
        System.out.println("testUpdateCategoryAttribute()");
    }
    
    public void testSelectFromCategoryAttribute()
    {
        System.out.println("testSelectFromCategoryAttribute()");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("CategoryAttributesDBTester");
        CategoryAttributesDBTester categoryAttributesDBTester = new CategoryAttributesDBTester();
        categoryAttributesDBTester.testselectAllCategoryAttributes();
        categoryAttributesDBTester.testInsertCategoryAttribute();
        categoryAttributesDBTester.testUpdateCategoryAttribute();
        categoryAttributesDBTester.testSelectFromCategoryAttribute();
    }
}
