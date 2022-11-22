package Model;

public class Product {
    private int productID;
    private String productName;
    private String brandName;
    private int price;
    private Enums.TypeOfProduct productType;
    private String productDetails;
    private int warrantyYears;
    private int additionalWarrantyYears;
    private int additionalWarrantyPrice;
    private int offer ;
    private float review;
    private int quantity;
    private Enums.ProductStatus productStatus;

    private int totalReview;
    public Product(int productID,String productName, String brandName, int price, String productDetails, int warrantyYears, int additionalWarrantyYears, int additionalWarrantyPrice, int offer,int quantity,Enums.TypeOfProduct productType)
    {   this.productID=productID;
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
        this.productDetails = productDetails;
        this.warrantyYears = warrantyYears;
        this.additionalWarrantyYears = additionalWarrantyYears;
        this.additionalWarrantyPrice = additionalWarrantyPrice;
        this.offer = offer;
        this.quantity=quantity;
        this.productType=productType;
    }
    public int getTotalReview()
    {
        return totalReview;
    }

    public void setTotalReview(int totalReview)
    {
        this.totalReview = totalReview;
    }

    public String getProductName() {
        return productName;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setProductType(Enums.TypeOfProduct productType) {
        this.productType = productType;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public void setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
    }

    public void setAdditionalWarrantyYears(int additionalWarrantyYears) {
        this.additionalWarrantyYears = additionalWarrantyYears;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductDetails() {
        return productDetails;
    }


    public int getWarrantyYears() {
        return warrantyYears;
    }


    public int getAdditionalWarrantyYears() {
        return additionalWarrantyYears;
    }

    public int getProductID() {
        return productID;
    }

    public float getOffer() {
        return offer;
    }


    public float getReview() {
        return review;
    }

    public void setReview(float review) {
        this.review = review;
    }

    public int getAdditionalWarrantyPrice() {
        return additionalWarrantyPrice;
    }

    public void setAdditionalWarrantyPrice(int additionalWarrantyPrice)
    {
        this.additionalWarrantyPrice = additionalWarrantyPrice;
    }

    public void setProductStatus(Enums.ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public Enums.TypeOfProduct getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public Enums.ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
