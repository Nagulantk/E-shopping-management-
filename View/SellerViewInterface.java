package View;

import Model.Enums;
import Model.Seller;

public interface SellerViewInterface
{
    void displaySellerMenu();

     Enums.SellerMenu sellerInputting();

     void sellerDetailsDisplay(Seller seller);
    void displayEditProductMenu();
     Enums.EditProductMenu editProductMenuInputting();
     void editProductResult(boolean condition);

}
