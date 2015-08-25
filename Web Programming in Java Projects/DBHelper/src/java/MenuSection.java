
import java.util.ArrayList;

/**
 * @title Expression title is undefined on line 2, column 13 in Templates/Classes/Class.java.
 * @date Mar 29, 2011
 * @author kottofy
 */

/**
 * @name MenuSection
 */
public class MenuSection {

    ArrayList menu;
    String categoryName;

    public MenuSection(String category)
    {
        menu = new ArrayList();
        categoryName = category;
    }

    public void addNewItem(String itemName, String description, double price)
    {
        MenuItem item = new MenuItem(itemName, description, price);
        menu.add(item);
    }

    public String getCategoryName()
    {
        return categoryName;
    }

}
