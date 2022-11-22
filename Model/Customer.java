package Model;

import java.util.ArrayList;

public class Customer extends User {

    private Cart cart=new Cart();
    private ArrayList<Coupon> couponList=new ArrayList<>();
    private ArrayList<Order> orders=new ArrayList<>();
    public Customer(String userName,String passWord,long phoneNumber,int flatNumber,String streetName,String townName,String districtName,String stateName,int pinCode, String emailId, Enums.Gender gender)
    {
        super(userName,passWord,phoneNumber,new Address(flatNumber,streetName,townName,districtName,stateName,pinCode),emailId,gender);

    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public ArrayList<Coupon> getCouponList() {
        return couponList;
    }
    public void setCouponList(Coupon coupon) {
      couponList.add(coupon);
    }
    public void setCouponList(ArrayList<Coupon> coupons) {
        couponList=coupons;
    }
    public void setOrders(Order order) {
          orders.add(order);
    }
    public ArrayList<Order> getOrders() {
       return orders;
    }

    public Cart getCart() {
        return cart;
    }
}
