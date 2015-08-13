
/**
 * @nameAndExt CategoryAttributesDB.java
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
public class CategoryAttributesDB
{

    /**
     *    public CategoryAttributes(AttributeValue attributeValue, Category category, Attribute attribute) {
     * @return
     */
    public ArrayList selectAllCategoryAttributes()
    {
        ArrayList list = null;
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                list = new ArrayList();
                ResultSet rs = con.prepareStatement("SELECT * FROM CategoryAttributes").executeQuery();
                while (rs.next())
                {
                    Integer catAttrId = rs.getInt("catAttrId");
                    Integer catIdFK = rs.getInt("catIdFK");
                    Integer attrIdFK = rs.getInt("attrIdFK");
                    Integer attrValueIdFK = rs.getInt("attrValueIdFK");
                    CategoryAttributes categoryAttributes = new CategoryAttributes(catAttrId, catIdFK, attrIdFK, attrValueIdFK);
                    list.add(categoryAttributes);
                }
            }
            catch (Exception e)
            {
                System.out.println("***** selectAllCategoryAttributes() failed... *****");
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

    public void insertCategoryAttribute()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement insertCategoryAttribute = con.prepareStatement("INSERT into CategoryAttribute (catIdFK, attrIdFK, attrValueIdFK) VALUES(?,?,?)");
            }
            catch (Exception e)
            {
                System.out.println("***** insertCategoryAttribute() failed... *****");
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

    public void updateCategoryAttribute()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement updateCategoryAttribute = con.prepareStatement("UPDATE CategoryAttribute SET catIdFK=?, attrIdFK=?, attrValueIdFK=? WHERE catAttrId=?");
            }
            catch (Exception e)
            {
                System.out.println("***** updateCategoryAttribute() failed... *****");
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

    public void selectFromCategoryAttribute()
    {
        Connection con = DBHelper_4050.getDBConnection();

        if (con != null)
        {
            try
            {
                PreparedStatement selectFromCategoryAttributes = con.prepareStatement("");
            }
            catch (Exception e)
            {
                System.out.println("***** selectFromCategoryAttribute() failed... *****");
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
