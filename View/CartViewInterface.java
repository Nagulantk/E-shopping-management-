package View;

import Model.Enums;

public interface CartViewInterface
{
     void displayCartMenu();
     Enums.CartMenu cartMenuInputting();
     int selectingProduct();
     void displayAddingProductToCartResult(boolean condition);
}

