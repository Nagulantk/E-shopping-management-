package View;

import Model.Enums;
import Model.Order;
import Model.Product;

public interface OrderViewInterface
{
     void displayOrderDetails(Order order);
      void displayOrderResult();
     Enums.Condition displayCouponMenu();
     Enums.Condition displayWarrantyMenu();
     Enums.Condition conditionMenuInputting();
     void displayApplyCouponResult(boolean condition);
     void displayAdditionalWarrantyResult();
     void paymentMenuDisplay();
     Enums.PaymentMenu paymentMenuInputting();
     void displayPaymentResult();
     int inputtingReview(Product product);
     void displayOrderResult(boolean condition);
     int purchaseQuantityInputting(Product product);
     void displayVerifyAddress();

}
