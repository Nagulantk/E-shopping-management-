package View;

import Model.Coupon;

import java.util.ArrayList;

public interface CouponViewInterface
{
     void displayCoupons(ArrayList<Coupon> coupons);
     void displayCoupon(Coupon coupon);
     int couponIDInputting(ArrayList<Coupon> coupons);
}
