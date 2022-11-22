package View;

import Model.Enums;

import java.util.Scanner;

public class AdminView implements AdminViewInterface{
    Scanner input=new Scanner(System.in);
    public Enums.AdminMenu adminMenuInputting()
    {
        displayAdminMenu();
        String adminMenuInput=input.nextLine();
        adminMenuInput=adminMenuInput.toUpperCase();
        Enums.AdminMenu process;
        try {
            process= Enums.AdminMenu.valueOf(adminMenuInput);
        }
        catch(Exception e)
        {
            System.out.println("Enter a valid request");
            return adminMenuInputting();
        }
        return process;
    }
    public void displayAdminMenu()
    {
        System.out.println("View products to verify");
        System.out.println("Logout");
    }
    public void displayVerifyProductMenu()
    {
        System.out.println("Do you allow this product for sales");

    }
    public void displayConditionMenu()
    {
        System.out.println("Yes");
        System.out.println("No");
    }
    public Enums.Condition conditionMenuInputting()
    {
        displayConditionMenu();
        String conditionMenuInput=input.nextLine();
        conditionMenuInput=conditionMenuInput.toUpperCase();
        Enums.Condition process;
        try {
            process= Enums.Condition.valueOf(conditionMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return conditionMenuInputting();
        }
        return process;
    }
    public void verifyProductResult(boolean condition)
    {
        if(condition)
        {
            System.out.println("Products is added to the server successFully and is ready for the sale");
        }
        else {
            System.out.println("Product is rejected SuccessFully");
        }
    }
}
