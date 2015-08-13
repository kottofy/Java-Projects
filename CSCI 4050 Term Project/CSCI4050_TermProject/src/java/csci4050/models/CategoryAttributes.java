package csci4050.models;

/**
 * 
 */
public class CategoryAttributes {

     private Integer catAttrId;
     private Integer catIdFK;
     private Integer attrIdFK;
     private Integer attrValueIdFK;

    public CategoryAttributes() {
    }

    public CategoryAttributes(Integer catIdFK, Integer attrIdFK, Integer attrValueIdFK)
    {
        this.catIdFK = catIdFK;
        this.attrIdFK = attrIdFK;
        this.attrValueIdFK = attrValueIdFK;
    }

    public CategoryAttributes(Integer catAttrId, Integer catIdFK, Integer attrIdFK, Integer attrValueIdFK)
    {
        this.catAttrId = catAttrId;
        this.catIdFK = catIdFK;
        this.attrIdFK = attrIdFK;
        this.attrValueIdFK = attrValueIdFK;
    }

    public Integer getAttrIdFK()
    {
        return attrIdFK;
    }

    public void setAttrIdFK(Integer attrIdFK)
    {
        this.attrIdFK = attrIdFK;
    }

    public Integer getAttrValueIdFK()
    {
        return attrValueIdFK;
    }

    public void setAttrValueIdFK(Integer attrValueIdFK)
    {
        this.attrValueIdFK = attrValueIdFK;
    }

    public Integer getCatAttrId()
    {
        return catAttrId;
    }

    public void setCatAttrId(Integer catAttrId)
    {
        this.catAttrId = catAttrId;
    }

    public Integer getCatIdFK()
    {
        return catIdFK;
    }

    public void setCatIdFK(Integer catIdFK)
    {
        this.catIdFK = catIdFK;
    }

}

