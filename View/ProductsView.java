package View;
import Controller.InputVerification;
import Model.Enums;
import Model.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsView implements ProductViewInterface {
    Scanner input=new Scanner(System.in);
    InputVerification inputVerification=new InputVerification();
    public void viewProducts(ArrayList<Product> products)
    {
        if(products!=null&&products.size()!=0)
        {   System.out.println("----------------------------------------------");
            for (Product product : products) {
            System.out.println("Product ID:"+product.getProductID());
            System.out.println("Name:" + product.getProductName());
            System.out.println("Brand:" + product.getBrandName());
            System.out.println("Product Details:" + product.getProductDetails());
            System.out.println("Original Mrp:" + product.getPrice());
            if (product.getOffer() != 0) {
                System.out.print("Offer:");
                System.out.print(product.getOffer());
                System.out.println("%");
                System.out.println("Price:" + (product.getPrice() - (product.getPrice() * product.getOffer()/100)));
            }
            System.out.println("Warranty:" + product.getWarrantyYears() + " Years");
            System.out.println("Additional Warranty:" + product.getAdditionalWarrantyYears() + " Years");
            System.out.println("Additional Warranty Price:" + product.getAdditionalWarrantyPrice());
            System.out.println("Stocks available:"+product.getQuantity());
            System.out.println("Review:" + product.getReview());
            System.out.println("Total reviews:"+product.getTotalReview());
            System.out.println("Status:"+product.getProductStatus());
            System.out.println("----------------------------------------------");
        }
    }
        else
        {
            System.out.println("No products Available");
        }

    }
    public void viewProduct(Product product)
    {if(product!=null) {
        System.out.println("----------------------------------------------");
        System.out.println("Product ID:" + product.getProductID());
        System.out.println("Name:" + product.getProductName());
        System.out.println("Brand:" + product.getBrandName());
        System.out.println("Product Details:" + product.getProductDetails());
        System.out.println("Original Mrp:" + product.getPrice());
        if (product.getOffer() != 0) {
            System.out.print("Offer:");
            System.out.print( product.getOffer());
            System.out.println("%");
            System.out.println("Price:" + (product.getPrice() - (product.getPrice() * product.getOffer() / 100)));
        }
        System.out.println("Warranty:" + product.getWarrantyYears() + " Years");
        System.out.println("Additional Warranty:" + product.getAdditionalWarrantyYears() + " Years");
        System.out.println("Additional Warranty Price:" + product.getAdditionalWarrantyPrice());
        System.out.println("Review:" + product.getReview());
        System.out.println("Total reviews:" + product.getTotalReview());
        System.out.println("----------------------------------------------");
    }
    else {
        System.out.println("No products Available");
    }
    }

    public void customerProductView(ArrayList<Product> products)
    {
        if (products != null && products.size() != 0) {
            System.out.println("----------------------------------------------");
            for (Product product : products) {
                System.out.println("Product ID:" + product.getProductID());
                System.out.println("Name:" + product.getProductName());
                System.out.println("Brand:" + product.getBrandName());
                System.out.println("Original Mrp:" + product.getPrice());
                System.out.println("Product Type:"+product.getProductType());
                if (product.getOffer() != 0)
                {
                    System.out.print("Offer:");
                    System.out.print(product.getOffer());
                    System.out.println("%");
                    System.out.println("Price:" + (product.getPrice() - (product.getPrice() * product.getOffer()/100)));
                }
                System.out.println("Quantity"+product.getQuantity());
                System.out.println("----------------------------------------------");
            }
        }
        else
        {
            System.out.println("No product Available");
        }
    }
    public void customerProductView(Product product)
    {
        if (product != null) {
            System.out.println("----------------------------------------------");

                System.out.println("Product ID:" + product.getProductID());
                System.out.println("Name:" + product.getProductName());
                System.out.println("Brand:" + product.getBrandName());
                System.out.println("Original Mrp:" + product.getPrice());
                System.out.println("Product Type:"+product.getProductType());
                if (product.getOffer() != 0)
                {
                    System.out.print("Offer:");
                    System.out.print(product.getOffer());
                    System.out.println("%");
                    System.out.println("Price:" + (product.getPrice() - (product.getPrice() * product.getOffer()/100)));
                }
                System.out.println("----------------------------------------------");
            }
    }
    public void displayTypeOfProductMenu()
    {
        System.out.println("Enter the type of product");
        System.out.println("Grossery");
        System.out.println("Dress");
        System.out.println("Electronics");
        System.out.println("Shoes");
    }
    public Enums.TypeOfProduct typeOfProductMenuInputting()
    {
        displayTypeOfProductMenu();
        String typeOfProductMenuInput=input.nextLine();
        typeOfProductMenuInput=typeOfProductMenuInput.toUpperCase();
        Enums.TypeOfProduct process;
        try {
            process= Enums.TypeOfProduct.valueOf(typeOfProductMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return typeOfProductMenuInputting();
        }
        return process;
    }

    public int removeProduct()
    {
        System.out.println("Enter the product ID to be removed");
        return input.nextInt();
    }
    public void removeProductResultDisplay(boolean condition)
    {
        if(condition)
        {
            System.out.println("Product is removed successfully");
        }
        else
        {
            System.out.println("Invalid ProductID");
        }
    }
    public String productNameInputting()
    {
        boolean condition=false;
        System.out.println("Enter Product Name:");
        String productName=null;
        while(!condition)
        {
            productName=input.nextLine();
            condition=inputVerification.verifyString(productName);
            if(!condition)
            {
                System.out.println("Enter a valid product name");
            }
        }

        return productName;

    }
    public String brandNameInputting()
    {  boolean condition=false;
        System.out.println("Enter Brand Name:");
        String brandName=null;
        while(!condition)
        {
            brandName=input.nextLine();
            condition=inputVerification.verifyString(brandName);
            if(!condition)
            {
                System.out.println("Enter a valid brand name");
            }
        }

        return brandName;
    }
    public String productDetailsInputting()
    {
        System.out.println("Enter Product Details:");
        return input.nextLine();
    }
    public int productPriceInputting()
    {
        return UserInputValidation.intValidation("Price");
    }
    public int productOfferInputting()
    {
        boolean condition=false;
        int offer=0;
        while(!condition){
            offer=UserInputValidation.intValidation("Offer");
            condition=inputVerification.verifyOffer(offer);
            if(!condition)
            {
                System.out.println("Enter the offer percentage less than or equal to 100");
            }
        }
      return offer;

    }
    public int productWarrantyYearsInputting()
    {
        return UserInputValidation.intValidation("Warranty Years");
    }
    public int productAdditionalWarrantyYearsInputting()
    {
        return UserInputValidation.intValidation("Additional Warranty Years");

    }
    public int productAdditionalWarrantyPriceInputting()
    {
        return UserInputValidation.intValidation("Additional Warranty Price");

    }
    public int productQuantityInputting()
    {
       return UserInputValidation.intValidation("Quantity");
    }
}
