
package jdbc;

import java.sql.*;

/**
 * Example 3.3
 */
public class Update
{

    public static void main(String args[])
    {
        Connection con = null;
        
        try
        {
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver).newInstance();
            String url = "jdbc:mysql://localhost/test";
            con = DriverManager.getConnection(url, "root", "");
            Statement s = con.createStatement();

            int update_count =
                    s.executeUpdate("INSERT INTO catalogItem(sku, description, price)"
                    + "VALUES(\"ko-999\", \"Rainbows and Butterflies\", \"00.00\")");

            System.out.println(update_count + " rows inserted.");
            s.close();
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
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
