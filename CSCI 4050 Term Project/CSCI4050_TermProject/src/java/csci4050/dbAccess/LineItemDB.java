
/**
 * @nameAndExt LineItemDB.java
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
public class LineItemDB
{

    public ArrayList selectAllLineItems()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM LineItems").executeQuery();
                while (rs.next())
                {
                    Integer lineItemId = rs.getInt("lineItemId");
                    Integer itemIdFK = rs.getInt("itemIdFK");
                    Integer orderIdFK = rs.getInt("orderIdFK");
                    Integer userIdFK = rs.getInt("userIdFK");
                    Integer quantity = rs.getInt("quantity");
                    LineItem lineItem = new LineItem(lineItemId, itemIdFK, orderIdFK, userIdFK, quantity);
                    list.add(lineItem);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllLineItems() failed... *****");
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

    public void insertLineItem()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertLineItem = con.prepareStatement("INSERT into LineItem (userIdFK, itemIdFK, quantity, orderIdFK) VALUES(?,?,?,?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertLineItem() failed... *****");
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

    public void updateLineItem()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateLineItem = con.prepareStatement("UPDATE LineItem SET userIdFK=?, itemIdFK=?, quantity=?, orderIdFK=? WHERE lineItemId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateLineItem() failed... *****");
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

    public void selectFromLineItem()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromLineItem = con.prepareStatement("");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromLineItem() failed... *****");
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
