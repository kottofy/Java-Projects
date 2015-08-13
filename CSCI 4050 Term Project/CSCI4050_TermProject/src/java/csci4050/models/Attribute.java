package csci4050.models;

/**
 * 
 */
public class Attribute {
    
     private Integer attrId;
     private String attrName;
     private String description;

    public Attribute() {
    }
	
    public Attribute(String attrName) {
        this.attrName = attrName;
    }

    public Attribute(String attrName, String description) {
       this.attrName = attrName;
       this.description = description;
    }

    public Attribute(Integer attrId, String attrName, String description)
    {
        this.attrId = attrId;
        this.attrName = attrName;
        this.description = description;
    }
   
    public Integer getAttrId() {
        return this.attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }
    
    public String getAttrName() {
        return this.attrName;
    }
    
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void printAttribute()
    {
        System.out.println("attrId: " + this.getAttrId() + " attrName: " + 
                this.getAttrName() + " attrDescription: " + this.getDescription());
    }
}


