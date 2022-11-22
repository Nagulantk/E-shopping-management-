package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
public class AdminLogin
{
    Admin admin= Admin.getAdmin();
    ProductViewInterface productsView=new ProductsView();
    AdminViewInterface adminView=new AdminView();
    Server server= Server.getServer();
    BackGroundProcess backGroundProcess=new BackGroundProcess();
    LoginViewInterface loginView=new LoginView();
    public void adminLoggingIn(Enums.UserTypeLogin userTypeLogin)
    {
        boolean logoutCondition = true;
        Admin admin = (Admin) backGroundProcess.loginDetailsValidate(loginView.userNameInputting(), loginView.passWordInputting(),userTypeLogin);
        while (logoutCondition) {
            if (admin != null) {
                Enums.AdminMenu adminInput = adminView.adminMenuInputting();
                if (adminInput == Enums.AdminMenu.VIEWPRODUCTSTOVERIFY)
                {
                   verifyProduct();
                }
                else {
                    logoutCondition = false;
                }

            }
        }
    }
    public void verifyProduct()
    {
        if(admin.getProductsToBeVerified().size()!=0) {
            for (Product product : admin.getProductsToBeVerified()) {
                productsView.viewProduct(product);
                adminView.displayVerifyProductMenu();
                if (adminView.conditionMenuInputting() == Enums.Condition.YES) {
                    product.setProductStatus(Enums.ProductStatus.ONFORSALE);
                    server.setProductList(product);
                    adminView.verifyProductResult(true);

                } else {
                    product.setProductStatus(Enums.ProductStatus.REJECTEDBYADMIN);
                    adminView.verifyProductResult(false);
                }
                admin.setProductsToBeVerified(new ArrayList<>());
            }
        }
        else {
            productsView.viewProduct(null);
        }

    }
}
