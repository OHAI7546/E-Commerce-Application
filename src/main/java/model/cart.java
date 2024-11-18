package model;

public class cart {

    private int id;
    private String userRole;
    private int productID;
    private int Quantity;
    private String productName;
    private int checkedOutTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCheckedOutTime() {
        return checkedOutTime;
    }

    public void setCheckedOutTime(int checkedOutTime) {
        this.checkedOutTime = checkedOutTime;
    }
}
