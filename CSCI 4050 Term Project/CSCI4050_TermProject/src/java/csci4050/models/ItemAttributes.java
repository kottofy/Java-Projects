package csci4050.models;

/**
 * 
 */
public class ItemAttributes {

    private Integer itemAttrId;
    private Integer itemIdFK;
    private Integer attrIdFK;
    private Integer attrValueFK;

    public ItemAttributes() {
    }

    public ItemAttributes(Integer itemIdFK, Integer attrIdFK, Integer attrValueFK)
    {
        this.itemIdFK = itemIdFK;
        this.attrIdFK = attrIdFK;
        this.attrValueFK = attrValueFK;
    }

    public ItemAttributes(Integer itemAttrId, Integer itemIdFK, Integer attrIdFK, Integer attrValueFK)
    {
        this.itemAttrId = itemAttrId;
        this.itemIdFK = itemIdFK;
        this.attrIdFK = attrIdFK;
        this.attrValueFK = attrValueFK;
    }

    public Integer getAttrIdFK()
    {
        return attrIdFK;
    }

    public void setAttrIdFK(Integer attrIdFK)
    {
        this.attrIdFK = attrIdFK;
    }

    public Integer getAttrValueFK()
    {
        return attrValueFK;
    }

    public void setAttrValueFK(Integer attrValueFK)
    {
        this.attrValueFK = attrValueFK;
    }

    public Integer getItemAttrId()
    {
        return itemAttrId;
    }

    public void setItemAttrId(Integer itemAttrId)
    {
        this.itemAttrId = itemAttrId;
    }
    
    public Integer getItemIdFK()
    {
        return itemIdFK;
    }

    public void setItemIdFK(Integer itemIdFK)
    {
        this.itemIdFK = itemIdFK;
    }
}
