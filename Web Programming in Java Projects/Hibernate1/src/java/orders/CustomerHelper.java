
/**
 * //comment
 * @nameAndExt CustomerHelper.java
 * @date Apr 12, 2011
 * @author Kristin Ottofy
 */
package orders;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * 
 */
public class CustomerHelper
{
    Session session = null;

    public CustomerHelper()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getCustomers()
    {
        List<Customer> customerList = null;
        try
        {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Customer");
            customerList = (List<Customer>) q.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return customerList;
    }

    public List getPurchaseOrders(int custID)
    {
        List<PurchaseOrder> purchaseOrdersList = null;
        try
        {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from PurchaseOrder as po where po.customerId=" + custID);
            purchaseOrdersList = (List<PurchaseOrder>) q.list();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return purchaseOrdersList;
    }

    public static void main (String[] args)
    {
        CustomerHelper ch = new CustomerHelper();
        List<Customer> customerList = ch.getCustomers();

        for (int i = 0; i < customerList.size(); i++)
        {
            System.out.println("Name: " + ((Customer)customerList.get(i)).getName());
            System.out.println("Number: " + ((Customer)customerList.get(i)).getPhone());
            int id = ((Customer)customerList.get(i)).getCustomerId();

            List<PurchaseOrder> purchaseOrders = ch.getPurchaseOrders(id);
            for (int n = 0; n < purchaseOrders.size(); n++)
            {
                System.out.println("Order Number: " + ((PurchaseOrder)purchaseOrders.get(n)).getOrderNum());
                System.out.println("Shipping Date: " + ((PurchaseOrder)purchaseOrders.get(n)).getShippingDate());
            }
        }
    }
}
