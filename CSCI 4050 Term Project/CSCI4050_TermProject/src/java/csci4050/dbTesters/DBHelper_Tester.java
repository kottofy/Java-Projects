/**
 * @nameAndExt DBHelper_Tester.java
 * @date Nov 9, 2011
 * @author Kristin Ottofy
 */

package csci4050.dbTesters;

import csci4050.dbAccess.*;
import csci4050.models.*;
import java.util.ArrayList;

/**
 * 
 */
public class DBHelper_Tester
{
    public static void main (String[] args)
    {  
        AttributeDBTester attributeDBTester = new AttributeDBTester();
        attributeDBTester.testSelectAllAttributes();
        attributeDBTester.testInsertAttribute();
        attributeDBTester.testUpdateAttribute();
        attributeDBTester.testSelectFromAttribute();
        
        AttributeValueDBTester attributeValueDBTester = new AttributeValueDBTester();
        attributeValueDBTester.testSelectAllAttributeValues();
        attributeValueDBTester.testInsertAttributeValue();
        attributeValueDBTester.testUpdateAttributeValue();
        attributeValueDBTester.testSelectFromAttributeValue();
        
        CategoryAttributesDBTester categoryAttributesDBTester = new CategoryAttributesDBTester();
        categoryAttributesDBTester.testselectAllCategoryAttributes();
        categoryAttributesDBTester.testInsertCategoryAttribute();
        categoryAttributesDBTester.testUpdateCategoryAttribute();
        categoryAttributesDBTester.testSelectFromCategoryAttribute();
        
        CategoryDBTester categoryDBTester = new CategoryDBTester();
        categoryDBTester.testSelectAllCategories();
        categoryDBTester.testInsertCategory();
        categoryDBTester.testUpdateCategory();
        categoryDBTester.testSelectFromCategory();
                        
        ItemAttributesDBTester itemAttributesDBTester = new ItemAttributesDBTester();
        itemAttributesDBTester.testSelectAllItemAttributes();
        itemAttributesDBTester.testInsertItemAttributes();
        itemAttributesDBTester.testUpdateItemAttributes();
        itemAttributesDBTester.testSelectFromItemAttributes();
        
        ItemDBTester itemDBTester = new ItemDBTester();
        itemDBTester.testSelectAllItems();
        itemDBTester.testInsertItem();
        itemDBTester.testUpdateItem();
        itemDBTester.testSelectFromItem();
        
        LineItemDBTester lineItemDBTester = new LineItemDBTester();
        lineItemDBTester.testSelectAllLineItems();
        lineItemDBTester.testInsertLineItem();
        lineItemDBTester.testUpdateLineItem();
        lineItemDBTester.testSelectFromLineItem();
        
        OrdersDBTester ordersDBTester = new OrdersDBTester();
        ordersDBTester.testSelectAllOrders();
        ordersDBTester.testInsertOrders();
        ordersDBTester.testUpdateOrders();
        ordersDBTester.testSelectFromOrders();
        
        UsersDBTester usersDBTester = new UsersDBTester();
        usersDBTester.testSelectAllUsers();
        usersDBTester.testInsertUsers();
        usersDBTester.testUpdateUsers();
        usersDBTester.testSelectFromUsers();
    }
}
