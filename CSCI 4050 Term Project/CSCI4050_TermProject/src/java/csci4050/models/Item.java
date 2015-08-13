package csci4050.models;

/**
 * 
 */
public class Item {

     private Integer itemId;
     private String itemName;
     private Integer quantity;
     private String description;
     private String manufacturer;
     private Double price;

    public Item() {
    }

    public Item(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
    
    public Item(Integer itemId, String itemName, int quantity, String description, String manufacturer, Double price ) {
       this.itemId = itemId;
        this.itemName = itemName;
       this.quantity = quantity;
       this.description = description;
       this.manufacturer = manufacturer;
       this.price = price;
    }
   
    public Integer getItemId() {
        return this.itemId;
    }
    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
}


