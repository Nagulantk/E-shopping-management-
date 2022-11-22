package Model;

public class Enums {
    public enum MainMenu
    {
        SIGNUP,
        LOGIN,
        EXIT
    }
    public enum UserTypeLogin
    {
        CUSTOMER,
        SELLER,
        ADMIN
    }
    public enum Gender
    {
        MALE,
        FEMALE,
        PREFERNOTTOSAY
    }
    public enum UserTypeSignUp
    {
        CUSTOMER,
        SELLER,

    }
    public enum SellerMenu
    {
        VIEWPROFILE,
        EDITPROFILE,
        YOURPRODUCTS,
        ADDPRODUCT,
        REMOVEPRODUCT,
        EDITPRODUCT,
        LOGOUT
    }
    public enum CustomerMenu
    {
        VIEWPROFILE,
        EDITPROFILE,
        APPLYFILTERS,
        SELECTPRODUCT,
        OPENCART,
        DISPLAYPREVIOUSORDERS,
        LOGOUT
    }
    public enum CartMenu
    {
        PLACEORDER,
        REMOVEPRODUCTFROMCART
    }
    public enum EditProfileMenu
    {
        USERNAME,
        PHONENUMBER,
        GENDER,
        EMAILID,
        PASSWORD,
        ADDRESS
    }
    public enum SelectProductMenu
    {
        ADDPRODUCTTOCART,
        BACK
    }
    public enum Condition
    {
        YES,
        NO
    }
    public enum PaymentMenu
    {
        PAYBYCASH,
        PAYTHROUGHONLINE
    }
    public enum FilterMenu
    {
        TYPEOFPRODUCT,
        PRICEOFTHEPRODUCT,
        BRAND

    }
    public enum TypeOfProduct
    {
        GROSSERY,
        DRESS,
        ELECTRONICS,
        SHOES
    }
   public enum AdminMenu
   {
       VIEWPRODUCTSTOVERIFY,
       LOGOUT
   }
   public enum ProductStatus
   {
       ONFORSALE,
       WAITINGFORVERIFICATION,
       REJECTEDBYADMIN
   }
    public enum EditProductMenu
    {
       PRODUCTNAME,
        BRANDNAME,
        PRODUCTDETAILS,
        ORIGINALMRP,
        OFFER,
        WARRANTYYEARS,
        ADDITIONALWARRANTYYEARS,
        ADDITIONALWARRANTYPRICE,
        QUANTITY,
        PRODUCTTYPE
    }

}
