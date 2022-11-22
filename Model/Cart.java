package Model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> productList=new ArrayList<>();

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(Product product) {
        productList.add(product);
    }
    public void setProductList(ArrayList<Product> products) {
        productList=products;
    }
}
