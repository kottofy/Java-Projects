package csci4050.models;

/**
 *
 */
public class LineItem  {

     private Integer lineItemId;
     private Integer itemIdFK;
     private Integer orderIdFK;
     private Integer userIdFK;
     private Integer quantity;

    public LineItem() {
    }

    public LineItem(Integer itemIdFK, Integer orderIdFK, Integer userIdFK, Integer quantity)
    {
        this.itemIdFK = itemIdFK;
        this.orderIdFK = orderIdFK;
        this.userIdFK = userIdFK;
        this.quantity = quantity;
    }

    public LineItem(Integer lineItemId, Integer itemIdFK, Integer orderIdFK, Integer userIdFK, Integer quantity)
    {
        this.lineItemId = lineItemId;
        this.itemIdFK = itemIdFK;
        this.orderIdFK = orderIdFK;
        this.userIdFK = userIdFK;
        this.quantity = quantity;
    }

    public Integer getItemIdFK()
    {
        return itemIdFK;
    }

    public void setItemIdFK(Integer itemIdFK)
    {
        this.itemIdFK = itemIdFK;
    }

    public Integer getLineItemId()
    {
        return lineItemId;
    }

    public void setLineItemId(Integer lineItemId)
    {
        this.lineItemId = lineItemId;
    }

    public Integer getOrderIdFK()
    {
        return orderIdFK;
    }

    public void setOrderIdFK(Integer orderIdFK)
    {
        this.orderIdFK = orderIdFK;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Integer getUserIdFK()
    {
        return userIdFK;
    }

    public void setUserIdFK(Integer userIdFK)
    {
        this.userIdFK = userIdFK;
    }
}
