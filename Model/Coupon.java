package Model;

public class Coupon {
    private long couponId;
    private int couponAmount;
    public Coupon(long couponId, int couponAmount) {
        this.couponId = couponId;
        this.couponAmount = couponAmount;
    }
    public long getCouponId() {
        return couponId;
    }
    public int getCouponAmount() {
        return couponAmount;
    }


}
