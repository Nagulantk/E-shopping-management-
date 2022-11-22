package Controller;
import Model.*;
import View.*;
public class MainMenuController {
    MainMenuViewInterface mainMenuView=new MainMenuView();
    SignUpViewInterface signUpView=new SignUpView();
    Server server= Server.getServer();
    GeneratingIDNumbers generatingIDNumbers=GeneratingIDNumbers.getGeneratingIDNumbers();
    AdminLogin adminLogin=new AdminLogin();
    CustomerLogin customerLogin=new CustomerLogin();
    SellerLogin sellerLogin=new SellerLogin();
    BackGroundProcess backGroundProcess=new BackGroundProcess();
    public void mainMenuProcessing()
    {
        boolean condition=true;
        while(condition) {
            Enums.MainMenu process = mainMenuView.mainMenuInputting();
            switch (process) {
                case SIGNUP:
                    Enums.UserTypeSignUp userType=mainMenuView.userTypeSignUpInputting();
                    switch (userType)
                    {
                        case CUSTOMER:
                            Customer customer=new Customer(signUpView.userNameInputting(),signUpView.passwordInputting(),backGroundProcess.validateUniquePhoneNumber(),signUpView.flatNumberInputting(),signUpView.streetNameInputting(),signUpView.townNameInputting(),signUpView.districtNameInputting(),signUpView.stateNameInputting(),signUpView.pinCodeInputting(),signUpView.emailInputting(),signUpView.genderInputting());
                            server.setCustomerList(customer);
                            break;
                        case SELLER:
                            Seller seller=new Seller(generatingIDNumbers.getSellerID(),signUpView.userNameInputting(),signUpView.passwordInputting(),backGroundProcess.validateUniquePhoneNumber(),signUpView.flatNumberInputting(),signUpView.streetNameInputting(),signUpView.townNameInputting(),signUpView.districtNameInputting(),signUpView.stateNameInputting(),signUpView.pinCodeInputting(),signUpView.emailInputting(),signUpView.genderInputting(),signUpView.aadhaarNumberInputting());
                            server.setSellerList(seller);
                            break;
                    }
                    break;
                case LOGIN:
                    Enums.UserTypeLogin userTypeLogin=mainMenuView.userTypeLoginInputting();
                    if(userTypeLogin== Enums.UserTypeLogin.CUSTOMER)
                    {
                        customerLogin.customerLoggingIn(Enums.UserTypeLogin.CUSTOMER);

                    }
                    else if(userTypeLogin== Enums.UserTypeLogin.SELLER)
                    {
                       sellerLogin.sellerLoggingIn(Enums.UserTypeLogin.SELLER);
                    }
                    else
                    {
                      adminLogin.adminLoggingIn(Enums.UserTypeLogin.ADMIN);
                    }
                    break;
                case EXIT:
                    condition = false;
            }
        }
    }
}
