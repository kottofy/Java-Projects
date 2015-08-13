package jdbc;
import java.sql.*;

/**
 * Example 3.4.
 */
public class UpdateLogic {
  public static void main(String args[]) {
    Connection con = null;

    try {
      String driver = "com.mysql.jdbc.Driver";

      Class.forName(driver).newInstance();
      String url = "jdbc:mysql://localhost/test";
      Statement s;

      con = DriverManager.getConnection(url, "root", "");
      con.setAutoCommit(false);  // make sure auto commit is off!
      s = con.createStatement();// create the first statement
      s.executeUpdate("INSERT INTO catalogItem(sku, description, price)"
                    + "VALUES(\"ko-888\", \"Jingle Bells\", \"80.00\")");
      s.close();                    // close the first statement

      s = con.createStatement();    // create the second statement
      s.executeUpdate("INSERT INTO catalogItem(sku, description, price)"
                    + "VALUES(\"ko-777\", \"Glitter Lollipops\", \"14.00\")");
      con.commit();                 // commit the two statements
      System.out.println("Insert succeeded.");
      s.close();                    // close the second statement
    }
    catch( Exception e ) {
      if( con != null ) {
        try { con.rollback(); }        // rollback on error
        catch( SQLException e2 ) { }
      }
      e.printStackTrace();
    }
    finally {
      if( con != null ) {
        try { con.close(); }
        catch( SQLException e ) { e.printStackTrace(); }
      }
    }
  }
}
