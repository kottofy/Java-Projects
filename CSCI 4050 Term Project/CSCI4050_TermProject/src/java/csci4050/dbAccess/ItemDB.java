
/**
 * @nameAndExt ItemDB.java
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
public class ItemDB
{

    public ArrayList selectAllItems()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM Items").executeQuery();
                while (rs.next())
                {
                    Integer itemId = rs.getInt("itemId");
                    String itemName = rs.getString("itemName");
                    Integer quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String manufacturer = rs.getString("manufacturer");
                    Double price = rs.getDouble("price");
                    Item item = new Item(itemId, itemName, quantity, description, manufacturer, price);
                    list.add(item);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllItems() failed... *****");
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

    public void insertItem()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertItem = con.prepareStatement("INSERT into Item (itemName, quantity, description, manufacturer, price) VALUES(?,?,?,?,?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertItem() failed... *****");
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

    public void updateItem()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateItem = con.prepareStatement("UPDATE Item SET itemName=?, quantity=?, description=?, manufacturer=?, price=? WHERE itemId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateItem() failed... *****");
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

    public void selectFromItem()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromItem = con.prepareStatement("");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromItem() failed... *****");
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
