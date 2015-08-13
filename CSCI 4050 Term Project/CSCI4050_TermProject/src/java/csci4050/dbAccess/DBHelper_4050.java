
/**
 *
 * @nameAndExt DBHelper_4050.java
 * @date Nov 8, 2011
 * @author Kristin Ottofy
 */
package csci4050.dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 */
public class DBHelper_4050
{

    /**
     *
     * @return
     */
    public static Connection getDBConnection()
    {
        Connection con = null;

        try
        {
            System.out.println("DBHelper_4050");
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            String url = "jdbc:mysql://uml.cs.uga.edu/team5";
            con = DriverManager.getConnection(url, "team5", "oodesign");
            System.out.println("Established DB Connection!");

            return con;
        }
        catch (Exception e)
        {
            System.out.println("***** getConnection() failed *****");
            System.out.println(e.getMessage());

            return null;
        }
    }
}
