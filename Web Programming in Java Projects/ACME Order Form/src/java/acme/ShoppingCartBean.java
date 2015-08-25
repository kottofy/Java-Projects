/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acme;

import java.util.ArrayList;

/**
 *
 * @author kottofy
 */
public class ShoppingCartBean {

    private ArrayList cart;
    private int itemID;
    private int quantity;

    public ArrayList getCart() {
        return cart;
    }

    public void setItemID(int itemID) {

        this.itemID = itemID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        LineItem temp = new LineItem(itemID, quantity);

        cart.add(temp);
    }

}
