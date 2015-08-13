
package jdbc;

/**
 * 
 */
import java.sql.*;

/**
 * Example 3.1.
 */
public class Select
{

    public static void main(String args[])
    {
        //jdbc:subprotocol:subname
        //subprotocol identifies which driver to use
        //subname provides the driver with any required connection information
        String url = "jdbc:mysql://localhost/test";
        Connection con = null;

        try
        {
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver).newInstance();
        }
        catch (Exception e)
        {
            System.out.println("Failed to load MySQL driver.");
            return;
        }
        try
        {
            con = DriverManager.getConnection(url, "root", "");
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery("SELECT * FROM customer");

            System.out.println("Got results:");
            while (result.next())
            { // process results one row at a time
                int key = result.getInt(1);
                String val = result.getString(2);

                System.out.println("key = " + key);
                System.out.println("val = " + val);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
