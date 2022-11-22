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
                case EDITPRODUCT:
                    editingProductDetails(seller);
                    break;
                case LOGOUT:
                    sellerCondition = false;
                    break;
            }

        }

    }
    public void removingProduct(Seller seller) {
        boolean removeProductCondition = false;
        int productID = productsView.selectProduct();
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
    public void editingProductDetails(Seller seller)
    {
        int productID = productsView.selectProduct();
        boolean editProductCondition=false;
        for (Product product : seller.getProductList())
        {
           if (product.getProductID() == productID)
           {
            Enums.EditProductMenu productMenu=sellerView.editProductMenuInputting();
            switch (productMenu)
            {
                case PRODUCTNAME:
                    product.setProductName(productsView.productNameInputting());
                    break;
                case BRANDNAME:
                    product.setBrandName(productsView.brandNameInputting());
                    break;
                case PRODUCTDETAILS:
                    product.setProductDetails(productsView.productDetailsInputting());
                    break;
                case ORIGINALMRP:
                    product.setPrice(productsView.productPriceInputting());
                    break;
                case OFFER:
                    product.setOffer(productsView.productOfferInputting());
                    break;
                case WARRANTYYEARS:
                    product.setWarrantyYears(productsView.productWarrantyYearsInputting());
                    break;
                case ADDITIONALWARRANTYYEARS:
                    product.setAdditionalWarrantyYears(productsView.productAdditionalWarrantyYearsInputting());
                    break;
                case ADDITIONALWARRANTYPRICE:
                    product.setAdditionalWarrantyPrice(productsView.productAdditionalWarrantyPriceInputting());
                    break;
                case QUANTITY:
                    product.setQuantity(productsView.productQuantityInputting());
                    break;
                case PRODUCTTYPE:
                    product.setProductType(productsView.typeOfProductMenuInputting());
                    break;
            }
            editProductCondition=true;
            break;
        }
       }
        sellerView.editProductResult(editProductCondition);

    }

}
