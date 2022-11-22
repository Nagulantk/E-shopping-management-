package View;

import Model.Enums;
import Model.Product;

import java.util.ArrayList;

public interface ProductViewInterface
{
     void viewProducts(ArrayList<Product> products);
     void viewProduct(Product product);

     void customerProductView(ArrayList<Product> products);
     void customerProductView(Product product);
     void displayTypeOfProductMenu();
     Enums.TypeOfProduct typeOfProductMenuInputting();

     int selectProduct();
     void removeProductResultDisplay(boolean condition);
     String productNameInputting();
     String brandNameInputting();
     String productDetailsInputting();
     int productPriceInputting();
     int productOfferInputting();
     int productWarrantyYearsInputting();
     int productAdditionalWarrantyYearsInputting();
     int productAdditionalWarrantyPriceInputting();
     int productQuantityInputting();
}



