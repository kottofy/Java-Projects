package csci4050.models;

/**
 *
 */
public class Category  {

     private Integer categoryId;
     private String catName;
     private Integer parentIdFK;

    public Category() {
    }
	
    public Category(String catName) {
        this.catName = catName;
    }

    public Category(String catName, Integer parentIdFK)
    {
        this.catName = catName;
        this.parentIdFK = parentIdFK;
    }

    public Category(Integer categoryId, String catName, Integer parentIdFK)
    {
        this.categoryId = categoryId;
        this.catName = catName;
        this.parentIdFK = parentIdFK;
    }
   
    public Integer getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getParentIdFK()
    {
        return parentIdFK;
    }

    public void setParentIdFK(Integer parentIdFK)
    {
        this.parentIdFK = parentIdFK;
    }

    public void printCategory()
    {
        System.out.println("categoryId: " + this.getCategoryId() + "catName: " + 
                this.getCatName() + "parentIdFK: " + this.getParentIdFK());
    }
    
}


