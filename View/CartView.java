package View;

import Model.Enums;

import java.util.Scanner;

public class CartView implements CartViewInterface{
    Scanner input=new Scanner(System.in);
    public  void displayCartMenu()
    {
        System.out.println("Place order");
        System.out.println("Remove product from cart");
    }
    public Enums.CartMenu cartMenuInputting()
    {
        displayCartMenu();
        String cartMenuInput=input.nextLine();
        cartMenuInput=cartMenuInput.toUpperCase();
        Enums.CartMenu process;
        try {
            process= Enums.CartMenu.valueOf(cartMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return cartMenuInputting();
        }
        return process;
    }
    public int selectingProduct()
    {
        System.out.println("Enter the Product ID");
        return input.nextInt();
    }
    public void displayAddingProductToCartResult(boolean condition)
    {
        if(condition)
        {
            System.out.println("Product is removed from the cart SuccessFully");
        }
        else
        {
            System.out.println("Product is not removed from the cart");
            System.out.println("Enter a valid Product ID");
        }
    }
}
