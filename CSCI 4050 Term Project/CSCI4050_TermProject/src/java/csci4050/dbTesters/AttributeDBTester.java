
/**
 * @nameAndExt AttributeDBTester.java
 * @date Nov 14, 2011
 * @author Kristin Ottofy
 */
package csci4050.dbTesters;

import csci4050.dbAccess.AttributeDB;
import csci4050.models.Attribute;
import java.util.ArrayList;
import java.lang.Math;

/**
 * 
 */
public class AttributeDBTester
{
    
    public void testSelectAllAttributes ()
    {  
        System.out.println("testSelectAllAttributes()");
        
        AttributeDB attrDB = new AttributeDB();
        ArrayList list = attrDB.selectAllAttributes();   
        
        for (int i = 0; i < list.size(); i++)
        {
            Attribute attr = (Attribute)list.get(i);
            attr.printAttribute();
        }
    }
    
    public void testInsertAttribute ()
    {
        System.out.println("testInsertAttribute()");
        
        AttributeDB attrDB = new AttributeDB();
        ArrayList list = attrDB.selectAllAttributes();
        int num = list.size()+1;
        attrDB.insertAttribute("attr" + num,"desc" + num );
        
        this.testSelectAllAttributes();
    }
    
    public void testUpdateAttribute ()
    {
        System.out.println("testUpdateAttribute()");
        
        
    }
    
    public void testSelectFromAttribute ()
    {
        System.out.println("testSelectFromAttribute()");
    }
    
    public static void main (String[] args)
    {
        System.out.println("AttrbuteBDTester");
        AttributeDBTester attributeDBTester = new AttributeDBTester();
        attributeDBTester.testSelectAllAttributes();
        attributeDBTester.testInsertAttribute();
        attributeDBTester.testUpdateAttribute();
        attributeDBTester.testSelectFromAttribute();
    }
}
