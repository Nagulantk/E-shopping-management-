package View;

import Model.Address;
import Model.Customer;
import Model.Enums;

import java.util.Scanner;

public class CustomerView implements CustomerViewInterface{
    Scanner input=new Scanner(System.in);
    public void displayCustomerMenu()
    {
        System.out.println("View Profile");
        System.out.println("Edit Profile");
        System.out.println("Select Product");
        System.out.println("Apply Filters");
        System.out.println("Open cart");
        System.out.println("Display previous orders");
        System.out.println("Logout");
    }
    public Enums.CustomerMenu customerInputting()
    {
        displayCustomerMenu();
        String customerMenuInput=input.nextLine();
       customerMenuInput=customerMenuInput.toUpperCase();
        Enums.CustomerMenu process;
        try {
            process= Enums.CustomerMenu.valueOf(customerMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return customerInputting();
        }
        return process;
    }
    public void customerDetailsDisplay(Customer customer)
    {
        System.out.println("Name:"+customer.getUserName());
        System.out.println("Phone Number:"+customer.getPhoneNumber());
        System.out.println("Gender:"+customer.getGender());
        System.out.println("EmailID:"+customer.getEmailId());
        displayAddress(customer.getAddress());
    }
    public void displayAddress(Address address)
    {
        System.out.println("Address:");
        System.out.println("Flat number:"+address.getFlatNo());
        System.out.println("Street Name:"+address.getStreetName());
        System.out.println("Town Name:"+address.getTownName());
        System.out.println("District Name:"+address.getDistrictName());
        System.out.println("State Name:"+address.getStateName());
        System.out.println("Pin code:"+address.getPinCode());
    }

}
