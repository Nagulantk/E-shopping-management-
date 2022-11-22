package Model;

import java.util.ArrayList;

public class Server {
    private ArrayList<Seller> sellerList=new ArrayList<>();
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Customer> customerList=new ArrayList<>();
    private ArrayList<Long> phoneNumberList=new ArrayList<>();
   static Server server=new Server();
    private Server()
    {

    }

    public ArrayList<Seller> getSellerList() {
        return sellerList;
    }

    public void setSellerList(Seller seller) {

        sellerList.add(seller);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(Product product) {
        productList.add(product);
    }
    public void setProductList(ArrayList<Product> products) {
        productList=products;
    }

    public ArrayList<Long> getPhoneNumberList()
    {
        return phoneNumberList;
    }
    public void setPhoneNumberList(long phoneNumber)
    {
        phoneNumberList.add(phoneNumber);
    }


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Customer customer) {
        customerList.add(customer);
    }
    public static Server getServer()
    {
        return server;
    }




}
