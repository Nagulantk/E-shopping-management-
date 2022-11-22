package Model;

import java.util.ArrayList;

public class Seller extends User{
    private int sellerID;
    private long aadhaarNumber;

    private ArrayList<Product> productList=new ArrayList<>();
    public Seller(int sellerID,String userName, String passWord, long phoneNumber, int flatNumber,String streetName,String townName,String districtName,String stateName,int pinCode, String emailId, Enums.Gender gender, long aadhaarNumber)
    {
        super(userName, passWord,phoneNumber,new Address(flatNumber,streetName,townName,districtName,stateName,pinCode),emailId,gender);
        this.sellerID=sellerID;
        this.aadhaarNumber = aadhaarNumber;
    }

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public int getSellerId() {
        return sellerID;
    }

    public void setProductList(Product product) {

        productList.add(product);
    }
    public void setProductList(ArrayList<Product> products) {

        productList=products;
    }

}
