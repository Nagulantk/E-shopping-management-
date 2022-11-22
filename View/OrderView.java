package View;
import Model.Enums;
import Model.Order;
import Model.Product;
import java.util.Scanner;

public class OrderView implements OrderViewInterface{
    ProductsView productsView=new ProductsView();
    Scanner input=new Scanner(System.in);

    public void displayOrderDetails(Order order)
    {
        System.out.println("OrderID:"+order.getOrderId());
        for(Product product:order.getProductWithQuantityList().keySet()) {
            productsView.customerProductView(product);
            System.out.println("Quantity:"+order.getProductWithQuantityList().get(product));
        }
        System.out.println("Tax:"+order.getTax());
        System.out.println("Total Amount:"+order.getTotalAmount());
        System.out.println("Ordered date:"+order.getOrderedDate());
        System.out.println("Delivery date:"+order.getDeliveryDate());

    }
    public void displayOrderResult()
    {
        System.out.println("You have not placed any orders");
    }
    public Enums.Condition displayCouponMenu()
    {
        System.out.println("If you want to apply coupon");
        System.out.println("Yes");
        System.out.println("No");
        return conditionMenuInputting();

    }
    public Enums.Condition displayWarrantyMenu()
    {
        System.out.println("If you want to apply additional warranty");
        System.out.println("Yes");
        System.out.println("No");
        return conditionMenuInputting();

    }
    public Enums.Condition conditionMenuInputting()
    {

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

    public void displayApplyCouponResult(boolean condition)
    {
        if(condition)
        {
            System.out.println("Coupon is applied successfully");
        }
        else {
            System.out.println("Coupon is not applied ");
            System.out.println("Enter a valid coupon id");
        }
    }
    public void displayAdditionalWarrantyResult()
    {

        System.out.println("Additional warranty  is applied successfully");
    }
    public void paymentMenuDisplay()
    {
        System.out.println("Enter the payment method");
        System.out.println("Pay by cash");
        System.out.println("Pay through online");
    }
    public Enums.PaymentMenu paymentMenuInputting()
    {
        paymentMenuDisplay();
        String paymentMenuInput=input.nextLine();
        paymentMenuInput=paymentMenuInput.toUpperCase();
        Enums.PaymentMenu process;
        try {
            process= Enums.PaymentMenu.valueOf(paymentMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return paymentMenuInputting();
        }
        return process;
    }
    public void displayPaymentResult()
    {
        System.out.println("Payment is SuccessFull");
    }
    public int inputtingReview(Product product)
    {
        System.out.println("Please give review for our product ProductID"+product.getProductID());
        int review=0;
        boolean condition=true;
        while(condition){
            review=UserInputValidation.intValidation("Review");
            if(review>5||review<0)
            {
                System.out.println("Give the review between 0 to 5");
            }
            else {
                condition=false;
            }

        }
        return review;

    }
    public void displayOrderResult(boolean condition)
    {
        if(condition)
        {
            System.out.println("Your products is ordered SuccessFully");
        }
        else
        {
            System.out.println("Order is not placed");
        }
    }
    public int purchaseQuantityInputting(Product product)
    {
        System.out.println("Enter the quantity of the Product need");
        boolean condition=false;
        int quantity = 0;
        while(!condition)
        {
             quantity=UserInputValidation.intValidation("Quantity");
            if(product.getQuantity()>=quantity)
            {
                condition=true;
            }
            else {
                System.out.println("The available quantity is "+product.getQuantity());
            }
        }
        return quantity;
    }
    public void displayVerifyAddress()
    {
        System.out.println("If you want to change the delivery location");
    }


}
