package View;

import Model.Enums;

import java.util.Scanner;

public class FilterView implements FilterViewInterface{
    Scanner input=new Scanner(System.in);

    public void displayFilterMenu()
    {
        System.out.println("Filter By");
        System.out.println("Type of Product");
        System.out.println("Price of the product");
        System.out.println("Brand");
    }
    public Enums.FilterMenu filterMenuInputting()
    {  displayFilterMenu();
        String filterMenuInput=input.nextLine();
        filterMenuInput=filterMenuInput.toUpperCase();
        Enums.FilterMenu process;
        try {
            process= Enums.FilterMenu.valueOf(filterMenuInput);
        }
        catch(Exception e)
        {
            System.out.println("Enter a valid request");
            return filterMenuInputting();
        }
        return process;
    }
    public String brandInputting()
    {
        System.out.println("Enter the brand name");
        return input.nextLine();
    }
    public int fromPriceInputting()
    {
        System.out.println("Enter the price range to filter");
         return UserInputValidation.intValidation("From Price");

    }
    public int toPriceInputting()
    {
        return UserInputValidation.intValidation("To Price");
    }


}
