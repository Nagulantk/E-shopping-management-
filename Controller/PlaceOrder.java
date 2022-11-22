package Controller;
import Model.*;
import View.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
public class PlaceOrder {
    OrderViewInterface orderView=new OrderView();
    CouponViewInterface couponView=new CouponView();
    GeneratingIDNumbers generatingIDNumbers=GeneratingIDNumbers.getGeneratingIDNumbers();
    CustomerViewInterface customerView=new CustomerView();
    AdminViewInterface adminView=new AdminView();
    SignUpViewInterface signUpView=new SignUpView();
    BackGroundProcess backGroundProcess=new BackGroundProcess();
    HashMap<Product,Integer> productAndQuantityList;
    public void placingOrder(ArrayList<Product> products, Customer customer)
    {

        if(products!=null&&products.size()!=0)
        {   productAndQuantityList=new HashMap<>();
            int purchaseAmount=calculatePurchaseAmount(products);
            Date date = new Date();
            SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
            String orderedDate = dateForm.format(date);
            LocalDate orderDate = LocalDate.parse(orderedDate);
            LocalDate deliveryDate = orderDate.plusDays(3);
            Enums.Condition condition = orderView.displayCouponMenu();
            if (condition == Enums.Condition.YES)
            {
                 purchaseAmount= purchaseAmount - applyCoupon(customer);
            }
            condition = orderView.displayWarrantyMenu();
            if (condition == Enums.Condition.YES) {
                purchaseAmount = purchaseAmount + applyAdditionalWarranty(products);
                orderView.displayAdditionalWarrantyResult();
            }
            verifyAddress(customer);
            float tax =purchaseAmount * payment();
            purchaseAmount = purchaseAmount + (int) tax;
             Order order = new Order(generatingIDNumbers.getOrderID(), productAndQuantityList, purchaseAmount, tax, orderDate, deliveryDate,customer.getAddress());
            orderView.displayOrderDetails(order);
            customerView.displayAddress(order.getDeliveryAddress());
            orderView.displayOrderResult(true);
            orderView.displayPaymentResult();
            reviewCalculation(products);
            customer.setOrders(order);
            Coupon coupon = backGroundProcess.generatingCoupons(order.getTotalAmount());
            customer.setCouponList(coupon);
            couponView.displayCoupon(coupon);
        }
        else
        {
            orderView.displayOrderResult(false);
        }

    }
    public int applyCoupon(Customer customer)
    {
      int couponID=couponView.couponIDInputting(customer.getCouponList());
      boolean couponCondition=false;
      int couponAmount=0;
        ArrayList<Coupon> couponArrayList= customer.getCouponList();
      if(couponID!=0) {
          for (Coupon coupon :couponArrayList) {
              if (coupon.getCouponId() == couponID) {
                  couponCondition = true;
                  couponAmount = coupon.getCouponAmount();
               couponArrayList.remove(coupon);
                  customer.setCouponList(couponArrayList);
                  break;
              }
          }
          orderView.displayApplyCouponResult(couponCondition);
          if (!couponCondition) {
              applyCoupon(customer);
          }
      }
      return couponAmount;

    }
    public int applyAdditionalWarranty(ArrayList<Product> products)
    {
        int totalAdditionalWarrantyAmount=0;
        for(Product product:products)
        {
           totalAdditionalWarrantyAmount=totalAdditionalWarrantyAmount+product.getAdditionalWarrantyPrice();
        }
        return totalAdditionalWarrantyAmount;
    }
    public float payment()
    {
        Enums.PaymentMenu paymentMethod=orderView.paymentMenuInputting();
        float tax;
        if(paymentMethod==Enums.PaymentMenu.PAYBYCASH)
        {
             tax=0.18f;
        }
        else
        {
            tax=0.25f;
        }
        return tax;
    }
    public void reviewCalculation(ArrayList<Product> products)
    {
        for(Product product:products)
        {
            int review=orderView.inputtingReview(product);
            product.setReview(((product.getReview()* product.getTotalReview())+review)/ (product.getTotalReview()+1));
            product.setTotalReview(product.getTotalReview()+1);
        }
    }
    public void verifyAddress(Customer customer)
    {
        customerView.displayAddress(customer.getAddress());
        orderView.displayVerifyAddress();
        Enums.Condition condition=adminView.conditionMenuInputting();
        if(Enums.Condition.YES==condition)
        {
            Address address=new Address(signUpView.flatNumberInputting(),signUpView.streetNameInputting(),signUpView.townNameInputting(),signUpView.districtNameInputting(),signUpView.stateNameInputting(),signUpView.pinCodeInputting());
            customer.setAddress(address);
        }
    }
   public int calculatePurchaseAmount(ArrayList<Product> products)
   {

       int finalAmount = 0;
       int productAmount ;
       for(Product product:products)
       {
           int productQuantity=orderView.purchaseQuantityInputting(product);
           product.setQuantity(product.getQuantity()-productQuantity);
           productAndQuantityList.put(product,productQuantity);
           productAmount = product.getPrice()*productQuantity;
           System.out.println(product.getPrice());
           System.out.println(product.getOffer());
           finalAmount = finalAmount + (int) (productAmount - (productAmount* product.getOffer()/100));
       }
       return finalAmount;
   }
}
