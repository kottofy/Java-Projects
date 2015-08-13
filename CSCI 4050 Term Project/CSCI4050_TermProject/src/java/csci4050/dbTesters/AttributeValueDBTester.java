/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package csci4050.dbTesters;

import csci4050.dbAccess.AttributeValueDB;
import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class AttributeValueDBTester
{
    public void testSelectAllAttributeValues()
    {
        System.out.println("testSelectAllAttributeValues()");
        AttributeValueDB attrValueDB = new AttributeValueDB();
        ArrayList list = attrValueDB.selectAllAttributeValues();
        for (int i = 0; i < list.size(); i++)
        {
            
        }
    }
    
    public void testInsertAttributeValue()
    {
        System.out.println("testInsertAttributeValue()");
    }
    
    public void testUpdateAttributeValue()
    {
        System.out.println("testUpdateAttributeValue()");
    }
    
    public void testSelectFromAttributeValue()
    {
        System.out.println("testSelectFromAttributeValue()");
    }

    public static void main(String[] args)
    {
        System.out.println("AttributeValueDBTester");
        AttributeValueDBTester attributeValueDBTester = new AttributeValueDBTester();
        attributeValueDBTester.testSelectAllAttributeValues();
        attributeValueDBTester.testInsertAttributeValue();
        attributeValueDBTester.testUpdateAttributeValue();
        attributeValueDBTester.testSelectFromAttributeValue();
    }
}
