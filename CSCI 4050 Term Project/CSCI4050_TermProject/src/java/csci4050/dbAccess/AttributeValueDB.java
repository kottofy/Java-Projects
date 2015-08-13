
/**
 * @nameAndExt AttributeValueDB.java
 * @date Nov 10, 2011
 * @author Kristin Ottofy
 */
package csci4050.dbAccess;

import csci4050.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */
public class AttributeValueDB
{

    /**
     *
     * @return
     */
    public ArrayList selectAllAttributeValues()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM AttributeValue").executeQuery();
                while (rs.next())
                {
                    Integer attrValueId = rs.getInt("attrValueId");
                    String attrValue = rs.getString("attrValue");
                    AttributeValue attributeValue = new AttributeValue(attrValueId, attrValue);
                    list.add(attributeValue);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllAttributeValues() failed... *****");
                System.out.println(e.getMessage());
            }
            finally
            {
                if (con != null)
                {
                    try
                    {
                        con.close();
                        System.out.println("Connection closed.");
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Closing connection failed");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return list;
    }

    public void insertAttributeValue()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertAttributeValue = con.prepareStatement("INSERT into AttributeValue (attrValue) VALUES(?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertAttributeValue() failed... *****");
                System.out.println(e.getMessage());
            }
            finally
            {
                if (con != null)
                {
                    try
                    {
                        con.close();
                        System.out.println("Connection closed.");
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Closing connection failed");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void updateAttributeValue()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateAttributeValue = con.prepareStatement("UPDATE AttributeValue SET attrValue=? WHERE attrValueId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateAttributeValue() failed... *****");
                System.out.println(e.getMessage());
            }
            finally
            {
                if (con != null)
                {
                    try
                    {
                        con.close();
                        System.out.println("Connection closed.");
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Closing connection failed");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void selectFromAttributeValue()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromAttributeValue = con.prepareStatement("");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromAttributeValue() failed... *****");
                System.out.println(e.getMessage());
            }
            finally
            {
                if (con != null)
                {
                    try
                    {
                        con.close();
                        System.out.println("Connection closed.");
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Closing connection failed");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
