
/**
 * @nameAndExt OrdersDB.java
 * @date Nov 10, 2011
 * @author Kristin Ottofy
 */
package csci4050.dbAccess;

import csci4050.models.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */
public class OrdersDB
{

    /**
     * public Orders(Users users, Date orderDate, Date shipDate, String orderStatus, Set lineItems) {
     * @return
     */
    public ArrayList selectAllOrders()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM Orders").executeQuery();
                while (rs.next())
                {
                    Integer orderId = rs.getInt("orderId");
                    Date orderDate = rs.getDate("orderDate");
                    Date shipDate = rs.getDate("shipDate");
                    String orderStatus = rs.getString("orderStatus");
                    String userIdFK = rs.getString("userIdFK");
                    Orders orders = new Orders(orderId, orderDate, shipDate, orderStatus, userIdFK);
                    list.add(orders);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllOrders() failed... *****");
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

    public void insertOrders()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertOrder = con.prepareStatement("INSERT into Orders (orderDate, shipDate, orderStatus, userIdFK) VALUES(?,?,?,?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertOrders() failed... *****");
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

    public void updateOrders()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateOrder = con.prepareStatement("UPDATE Orders SET orderDate=?, shipDate=?, orderStatus=?, userIdFK=? WHERE orderId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateOrders() failed... *****");
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

    public void selectFromOrders()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromOrders = con.prepareStatement("SELECT FROM ");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromOrders() failed... *****");
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
