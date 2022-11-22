package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;

public class SellerLogin {
    LoginViewInterface loginView = new LoginView();
    Server server = Server.getServer();
    Admin admin = Admin.getAdmin();
    BackGroundProcess backGroundProcess=new BackGroundProcess();
    ProductViewInterface productsView = new ProductsView();
    SellerViewInterface sellerView = new SellerView();
    GeneratingIDNumbers generatingIDNumbers = GeneratingIDNumbers.getGeneratingIDNumbers();

    public void sellerLoggingIn(Enums.UserTypeLogin userTypeLogin) {
        Seller seller = (Seller) backGroundProcess.loginDetailsValidate(loginView.userNameInputting(), loginView.passWordInputting(), userTypeLogin);
        loginView.loginStatus(seller);
        boolean sellerCondition = true;
        while (sellerCondition && seller != null) {
            Enums.SellerMenu sellerInput = sellerView.sellerInputting();
            switch (sellerInput) {
                case VIEWPROFILE:
                    sellerView.sellerDetailsDisplay(seller);
                    break;
                case EDITPROFILE:
                    backGroundProcess.profileEditing(seller);
                    break;
                case YOURPRODUCTS:
                    productsView.viewProducts(seller.getProductList());
                    break;
                case ADDPRODUCT:
                    addingProductForSale(seller);
                    break;
                case REMOVEPRODUCT:
                    removingProduct(seller);
                    break;
                case LOGOUT:
                    sellerCondition = false;
                    break;
            }

        }

    }
    public void removingProduct(Seller seller) {
        boolean removeProductCondition = false;
        int productID = productsView.removeProduct();
        for (Product products : seller.getProductList()) {
            if (products.getProductID() == productID) {
                ArrayList<Product> sellerProductList = seller.getProductList();
                sellerProductList.remove(products);
                seller.setProductList(sellerProductList);
                ArrayList<Product> totalProductList = server.getProductList();
                totalProductList.remove(products);
                server.setProductList(totalProductList);
                removeProductCondition = true;
                break;
            }
        }
        productsView.removeProductResultDisplay(removeProductCondition);
    }
    public void addingProductForSale(Seller seller)
    {
        Product product = new Product(generatingIDNumbers.getProductID(), productsView.productNameInputting(), productsView.brandNameInputting(), productsView.productPriceInputting(), productsView.productDetailsInputting(), productsView.productWarrantyYearsInputting(), productsView.productAdditionalWarrantyYearsInputting(), productsView.productAdditionalWarrantyPriceInputting(), productsView.productOfferInputting(), productsView.productQuantityInputting(), productsView.typeOfProductMenuInputting());
        product.setProductStatus(Enums.ProductStatus.WAITINGFORVERIFICATION);
        seller.setProductList(product);
        admin.setProductsToBeVerified(product);
    }

}
