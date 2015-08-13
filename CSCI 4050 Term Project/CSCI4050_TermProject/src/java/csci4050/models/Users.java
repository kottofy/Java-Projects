package csci4050.models;

/**
 * 
 */
public class Users {

     private Integer userId;
     private String username;
     private String password;
     private String userType;
     private String firstName;
     private String lastName;
     private String shippingStreet;
     private String shippingCity;
     private String shippingState;
     private String shippingZip;
     private String billingStreet;
     private String billingCity;
     private String billingState;
     private String billingZip;
     private String phoneNumber;
     private String email;
     private String creditCard;

    public Users() {
    }

	
    public Users(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    public Users(String username, String password, String userType, String firstName, String lastName, String shippingStreet, String shippingCity, String shippingState, String shippingZip, String billingStreet, String billingCity, String billingState, String billingZip, String phoneNumber, String email, String creditCard) {
       this.username = username;
       this.password = password;
       this.userType = userType;
       this.firstName = firstName;
       this.lastName = lastName;
       this.shippingStreet = shippingStreet;
       this.shippingCity = shippingCity;
       this.shippingState = shippingState;
       this.shippingZip = shippingZip;
       this.billingStreet = billingStreet;
       this.billingCity = billingCity;
       this.billingState = billingState;
       this.billingZip = billingZip;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.creditCard = creditCard;
    }

    public Users(Integer userId, String username, String password, String userType, String firstName, String lastName, String shippingStreet, String shippingCity, String shippingState, String shippingZip, String billingStreet, String billingCity, String billingState, String billingZip, String phoneNumber, String email, String creditCard)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingStreet = shippingStreet;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingZip = shippingZip;
        this.billingStreet = billingStreet;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingZip = billingZip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creditCard = creditCard;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserType() {
        return this.userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getShippingStreet() {
        return this.shippingStreet;
    }
    
    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }
    public String getShippingCity() {
        return this.shippingCity;
    }
    
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }
    public String getShippingState() {
        return this.shippingState;
    }
    
    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }
    public String getShippingZip() {
        return this.shippingZip;
    }
    
    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }
    public String getBillingStreet() {
        return this.billingStreet;
    }
    
    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }
    public String getBillingCity() {
        return this.billingCity;
    }
    
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
    public String getBillingState() {
        return this.billingState;
    }
    
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }
    public String getBillingZip() {
        return this.billingZip;
    }
    
    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCreditCard() {
        return this.creditCard;
    }
    
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}


