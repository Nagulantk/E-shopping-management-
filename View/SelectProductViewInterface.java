package View;

import Model.Enums;

public interface SelectProductViewInterface
{
     void displaySelectProductMenu();
     int selectingProduct();
     void displaySelectProductResult(boolean conditon);
     Enums.SelectProductMenu selectProductMenuInputting();
     void displayAddingProductToCartResult();
}


