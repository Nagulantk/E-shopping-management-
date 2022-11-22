package View;

import Model.Enums;

import java.util.Scanner;

public class SelectProductView implements SelectProductViewInterface{
    Scanner input=new Scanner(System.in);
    public void displaySelectProductMenu()
    {
        System.out.println("Add product to cart");
        System.out.println("Back");
    }
    public int selectingProduct()
    {
        System.out.println("Enter the Product ID");
        return input.nextInt();
    }
    public void displaySelectProductResult(boolean conditon)
    {
        if(conditon)
        {
            System.out.println("Product is selected successfully");
        }
        else
        {
            System.out.println("Product is not selected");
            System.out.println("Enter a valid product ID");
        }

    }
    public Enums.SelectProductMenu selectProductMenuInputting()
    {
        displaySelectProductMenu();
        String selectProductMenuInput=input.nextLine();
        selectProductMenuInput=selectProductMenuInput.toUpperCase();
        Enums.SelectProductMenu process;
        try {
            process= Enums.SelectProductMenu.valueOf(selectProductMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return selectProductMenuInputting();
        }
        return process;
    }
    public void displayAddingProductToCartResult()
    {
        System.out.println("Product is added to the cart SuccessFully");
    }
}
