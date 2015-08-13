
/**
 * @nameAndExt UsersDB.java
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
public class UsersDB
{

    public ArrayList selectAllUsers()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM Users").executeQuery();
                while (rs.next())
                {
                    Integer userId = rs.getInt("userId");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String userType = rs.getString("userType");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String shippingStreet = rs.getString("shippingStreet");
                    String shippingCity = rs.getString("shippingCity");
                    String shippingState = rs.getString("shippingState");
                    String shippingZip = rs.getString("shippingZip");
                    String billingStreet = rs.getString("billingStreet");
                    String billingCity = rs.getString("billingCity");
                    String billingState = rs.getString("billingState");
                    String billingZip = rs.getString("billingZip");
                    String phoneNumber = rs.getString("phoneNumber");
                    String email = rs.getString("email");
                    String creditCard = rs.getString("creditCard");
                    Users users = new Users(userId, username, password, userType, firstName, lastName, shippingStreet, shippingCity, shippingState, shippingZip, billingStreet, billingCity, billingState, billingZip, phoneNumber, email, creditCard);
                    list.add(users);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllUsers() failed... *****");
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

    public void insertUsers()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertUser = con.prepareStatement("INSERT into User (username, password, userType, "
                        + "firstName, lastName, shippingStreet, shippingCity, "
                        + "shippingState, shippingZip, billingStreet, billingCity,"
                        + "billingState, billingZip, phoneNumber, email, creditCard) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertUsers() failed... *****");
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

    public void updateUsers()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateUser = con.prepareStatement("UPDATE User SET password=?, userType=?, "
                        + "firstName=?, lastName=?, shippingStreet=?, shippingCity=?, "
                        + "shippingState=?, shippingZip=?, billingStreet=?, billingCity=?,"
                        + "billingState=?, billingZip=?, phoneNumber=?, email=?, creditCard=? WHERE userId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateUsers() failed... *****");
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

    public void selectFromUsers()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromUsers = con.prepareStatement("SELECT FROM Users WHERE username=?");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromUsers() failed... *****");
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
