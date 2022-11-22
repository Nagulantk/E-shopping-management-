package Model;

import java.util.ArrayList;

public class Admin extends User{
    private ArrayList<Product> productsToBeVerified=new ArrayList<>();
    static Admin admin=new Admin();
    private Admin()
    {
        super("Nagulan","@3Wertyuiop",9842915520L,new Address(106,"gandhijinagar","chithode","covai","tamilnadu",638102),"nag@gmail.com", Enums.Gender.MALE);
    }

    public static Admin getAdmin() {
        return admin;
    }
    public ArrayList<Product> getProductsToBeVerified() {
        return productsToBeVerified;
    }

    public void setProductsToBeVerified(Product product) {
        productsToBeVerified.add(product);
    }
    public void setProductsToBeVerified(ArrayList<Product> products) {
        productsToBeVerified=products;
    }

}
