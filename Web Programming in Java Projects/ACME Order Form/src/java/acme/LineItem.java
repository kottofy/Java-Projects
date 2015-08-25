/* entity class
 */

package acme;

/**
 *
 * @author kottofy
 */
public class LineItem {

    private int itemID;
    private int quantity;
    private String description;

    public String getDescription() {
        return description;
    }

    public int getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    static String[] itemDescription = {"Rocket-powered Roller Skates",
                                "Exploding tennis balls, case",
                                "Dehydrated Boulder",
                                "Earthquake Pill, bottle of 12",
                                "Batman Outfit",
                                "Catapult"};

    public LineItem(int itemID, int quantity)
    {
        this.itemID = itemID;
        this.quantity = quantity;
        this.description = itemDescription[itemID];
    }

}
