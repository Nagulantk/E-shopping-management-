package Controller;

public class GeneratingIDNumbers {
    private  int sellerID=1;
    private  int productID=1;
    private int orderID=1;
    private int couponID;
    static GeneratingIDNumbers generatingIDNumbers=new GeneratingIDNumbers();
    private GeneratingIDNumbers()
    {

    }

    public static GeneratingIDNumbers getGeneratingIDNumbers() {
        return generatingIDNumbers;
    }

    public int getSellerID() {
        return sellerID++;
    }

    public int getProductID() {
        return productID++;
    }
    public int getOrderID()
    {
        return orderID++;
    }
    public int getCouponID()
    {
        return couponID++;
    }
}
