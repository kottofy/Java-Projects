
package csci4050.models;

import java.util.Date;

/**
 * 
 */
public class Orders 
{

    private Integer orderId;
    private Date orderDate;
    private Date shipDate;
    private String orderStatus;
    private String userIdFK;

    public Orders()
    {
    }

    public Orders(Date orderDate, Date shipDate, String orderStatus)
    {
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
    }

    public Orders(Date orderDate, Date shipDate, String orderStatus, String userIdFK)
    {
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
        this.userIdFK = userIdFK;
    }

    public Orders(Integer orderId, Date orderDate, Date shipDate, String orderStatus, String userIdFK)
    {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
        this.userIdFK = userIdFK;
    }
    
    public Integer getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }

    public Date getOrderDate()
    {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public Date getShipDate()
    {
        return this.shipDate;
    }

    public void setShipDate(Date shipDate)
    {
        this.shipDate = shipDate;
    }

    public String getOrderStatus()
    {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public String getUserIdFK()
    {
        return this.userIdFK;
    }

    public void setUsers(String userIdFK)
    {
        this.userIdFK = userIdFK;
    }
}
