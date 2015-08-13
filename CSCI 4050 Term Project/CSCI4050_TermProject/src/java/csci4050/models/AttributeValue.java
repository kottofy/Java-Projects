package csci4050.models;

/**
 * 
 */
public class AttributeValue  {

     private Integer attrValueId;
     private String attrValue;

    public AttributeValue() {
    }

    public AttributeValue(String attrValue) {
       this.attrValue = attrValue;
    }

    public AttributeValue(Integer attrValueId, String attrValue)
    {
        this.attrValueId = attrValueId;
        this.attrValue = attrValue;
    }
   
    public Integer getAttrValueId() {
        return this.attrValueId;
    }

    public void setAttrValueId(Integer attrValueId) {
        this.attrValueId = attrValueId;
    }
    
    public String getAttrValue() {
        return this.attrValue;
    }
    
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }
    
    public void printAttributeValue()
    {
        System.out.println("attrValueId: " + this.getAttrValueId() + 
                " attrValue: " + this.getAttrValue());
    }
}


