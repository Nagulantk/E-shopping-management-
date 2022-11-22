package View;

import Model.Coupon;

import java.util.ArrayList;

public class CouponView implements CouponViewInterface{
    public void displayCoupons(ArrayList<Coupon> coupons)
    {
        if(coupons!=null&&coupons.size()!=0)
        {
            for(Coupon coupon:coupons)
            {
                System.out.println("Coupon ID:"+coupon.getCouponId());
                System.out.println("Coupon amount:"+coupon.getCouponAmount());
            }

        }
        else
        {
            System.out.println("No coupon available for you");
        }

    }
    public void displayCoupon(Coupon coupon)
    {
        System.out.println("You have got a new coupon");
        System.out.println("CouponID:"+coupon.getCouponId());
        System.out.println("Coupon Amount:"+coupon.getCouponAmount());
        System.out.println("You can use this coupon for your next order");

    }
    public int couponIDInputting(ArrayList<Coupon> coupons)
    {
        displayCoupons(coupons);
        if(coupons.size()!=0) {
            return UserInputValidation.intValidation("CouponID");
        }
        return 0;
    }
}
