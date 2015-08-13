
/**
 * @nameAndExt ItemAttributesDB.java
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
public class ItemAttributesDB
{

    public ArrayList selectAllItemAttributes()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM ItemAttributes").executeQuery();
                while (rs.next())
                {
                    Integer itemAttrId = rs.getInt("itemAttrId");
                    Integer itemIdFK = rs.getInt("itemIdFK");
                    Integer attrIdFK = rs.getInt("attrIdFK");
                    Integer attrValueFK = rs.getInt("attrValueFK");
                    ItemAttributes itemAttributes = new ItemAttributes(itemAttrId, itemIdFK, attrIdFK, attrValueFK);
                    list.add(itemAttributes);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllItemAttributes() failed... *****");
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

    public void insertItemAttributes()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertItemAttribute = con.prepareStatement("INSERT into ItemAttribute (itemIdFK, attrIdFK, attrValueIdFK) VALUES(?,?,?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertItemAttributes() failed... *****");
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

    public void updateItemAttributes()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateItemAttribute = con.prepareStatement("UPDATE ItemAttributes SET itemIdFK=?, attrIdFK=?, attrValueIdFK=? WHERE itemAttrId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateItemAttributes() failed... *****");
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

    public void selectFromItemAttributes()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromItemAttribute = con.prepareStatement("");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromItemAttributes() failed... *****");
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
