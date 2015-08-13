
/**
 * @nameAndExt AttributeDB.java
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
public class AttributeDB
{

    /**
     *
     * @return ArrayList of Attributes only with names
     */
    public ArrayList selectAllAttributes()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM Attribute").executeQuery();
                while (rs.next())
                {
                    /*******    MIGHT NEED TO CHECK FOR NULL   **********/
                    String attrName = rs.getString("attrName");
                    Integer attrId = rs.getInt("attrId");
                    String description = rs.getString("description");
                    Attribute attr = new Attribute(attrId, attrName, description);
                    list.add(attr);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllAttributes() failed... *****");
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

    public void insertAttribute(String attrName, String description)
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertAttribute = con.prepareStatement(
                        "INSERT into Attribute (attrName, description) "
                        + "VALUES(?,?)");
                insertAttribute.setString(1, attrName);
                insertAttribute.setString(2, description);
                insertAttribute.execute();
            }
            catch (Exception e)
            {
                System.out.println("***** insertAttribute() failed... *****");
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

    public void updateAttribute()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateAttribute = con.prepareStatement("UPDATE Attribute SET attrName=?, description=? WHERE attrId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateAttribute() failed... *****");
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

    public void selectFromAttribute()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromAttributes = con.prepareStatement("");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromAttribute() failed... *****");
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
