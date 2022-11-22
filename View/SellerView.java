package View;
import Model.Enums;
import Model.Seller;

import java.util.Scanner;

public class SellerView implements SellerViewInterface{
    Scanner input=new Scanner(System.in);
    public void displaySellerMenu()
    {
        System.out.println("View profile");
        System.out.println("Edit profile");
        System.out.println("Your products");
        System.out.println("Add Product");
        System.out.println("Remove Product");
        System.out.println("Edit product");
        System.out.println("Logout");
    }
    public Enums.SellerMenu sellerInputting()
    {
        displaySellerMenu();
        String sellerMenuInput=input.nextLine();
        sellerMenuInput=sellerMenuInput.toUpperCase();
        Enums.SellerMenu process;
        try {
            process= Enums.SellerMenu.valueOf(sellerMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return sellerInputting();
        }
        return process;
    }
    public void sellerDetailsDisplay(Seller seller)
    { System.out.println("Seller Id"+seller.getSellerId());
        System.out.println("Name:"+seller.getUserName());
        System.out.println("Phone Number:"+seller.getPhoneNumber());
        System.out.println("Gender:"+seller.getGender());
        System.out.println("EmailID:"+seller.getEmailId());
        System.out.println("Address:");
        System.out.println("Flat number:"+seller.getAddress().getFlatNo());
        System.out.println("Street Name:"+seller.getAddress().getStreetName());
        System.out.println("Town Name:"+seller.getAddress().getTownName());
        System.out.println("District Name:"+seller.getAddress().getDistrictName());
        System.out.println("State Name:"+seller.getAddress().getStateName());
        System.out.println("Pin code:"+seller.getAddress().getPinCode());
        System.out.println("Aadhar Number:"+seller.getAadhaarNumber());
    }
    public void displayEditProductMenu()
    {
        System.out.println("Enter the details to be edited");
        System.out.println("Product Name");
        System.out.println("Brand Name");
        System.out.println("Product Details");
        System.out.println("Original Mrp");
        System.out.println("Offer");
        System.out.println("Warranty Years");
        System.out.println("Additional Warranty Years");
        System.out.println("Additional Warranty Price" );
        System.out.println("Quantity");
        System.out.println("Product Type");
    }
    public Enums.EditProductMenu editProductMenuInputting()
    {
        displayEditProductMenu();
        String productMenu=input.nextLine();
        productMenu=productMenu.toUpperCase();
        Enums.EditProductMenu process;
        try {
            process= Enums.EditProductMenu.valueOf(productMenu);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return editProductMenuInputting();
        }
        return process;
    }
    public void editProductResult(boolean condition)
    {
        if(condition)
        {
            System.out.println("Product is edited successfully");
        }
        else
        {
            System.out.println("Enter a valid product Id");
        }
    }
}
