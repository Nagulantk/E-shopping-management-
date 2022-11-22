package View;

import Model.Address;
import Model.Customer;
import Model.Enums;

public interface CustomerViewInterface
{
    void displayCustomerMenu();
    Enums.CustomerMenu customerInputting();
     void customerDetailsDisplay(Customer customer);
     void displayAddress(Address address);
}
