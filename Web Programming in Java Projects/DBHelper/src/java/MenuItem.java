/**
 * @title Expression title is undefined on line 2, column 13 in Templates/Classes/Class.java.
 * @date Mar 29, 2011
 * @author kottofy
 */

/**
 * @name MenuItem
 */
public class MenuItem {

    String itemName, description;
    double price;

    public MenuItem(String item, String desc, double p)
    {
        itemName = item;
        description = desc;
        price = p;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getDescription()
    {
        return description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double newPrice)
    {
        price = newPrice;
    }

}
