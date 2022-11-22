package Controller;
import Model.*;
import View.*;

import java.util.ArrayList;

public class BackGroundProcess {
    SignUpViewInterface signUpView=new SignUpView();
    EditProfileViewInterface editProfileView=new EditProfileView();
    Server server =Server.getServer();
    GeneratingIDNumbers generatingIDNumbers=GeneratingIDNumbers.getGeneratingIDNumbers();
    public void profileEditing(User user)
    {
        Enums.EditProfileMenu editProfileInput = editProfileView.editProfileMenuInputting();
        switch (editProfileInput)
        {
            case USERNAME:
                user.setUserName(signUpView.userNameInputting());
                break;
            case PHONENUMBER:
                user.setPhoneNumber(validateUniquePhoneNumber());
                break;
            case PASSWORD:
                user.setPassWord(signUpView.passwordInputting());
                break;
            case GENDER:
                user.setGender(signUpView.genderInputting());
                break;
            case EMAILID:
                user.setEmailId(signUpView.streetNameInputting());
                break;
            case ADDRESS:
                user.setAddress(new Address(signUpView.flatNumberInputting(),signUpView.streetNameInputting(),signUpView.townNameInputting(),signUpView.districtNameInputting(),signUpView.stateNameInputting(),signUpView.pinCodeInputting()));
                break;
        }
        editProfileView.editProfileResult();
    }
    public Coupon generatingCoupons(int billAmount)
    {
        if(billAmount>500&&billAmount<1000)
        {
            return new Coupon(generatingIDNumbers.getCouponID(),20 );
        }
        else if(billAmount<5000)
        {
            return new Coupon(generatingIDNumbers.getCouponID(),50 );
        }
        else if(billAmount<10000)
        {
            return new Coupon(generatingIDNumbers.getCouponID(),70 );
        }
        else
        {
            return new Coupon(generatingIDNumbers.getCouponID(),100 );

        }
    }
    public long validateUniquePhoneNumber()
    {
        long phoneNumber=signUpView.  phoneNumberInputting();
        if(server.getPhoneNumberList().contains(phoneNumber))
        {
            signUpView.uniquePhoneNumberValidateResult();
            return validateUniquePhoneNumber();
        }
        server.setPhoneNumberList(phoneNumber);
        return phoneNumber;
    }
    public User loginDetailsValidate(String userName, String password, Enums.UserTypeLogin userTypeLogin)
    {
        ArrayList<Customer> customerList=server.getCustomerList();
        ArrayList<Seller> sellerList=server.getSellerList();
        if(userTypeLogin== Enums.UserTypeLogin.CUSTOMER)
        {
            for (Customer customer : customerList) {
                if (customer.getUserName().equals(userName) && customer.getPassWord().equals(password)) {
                    return customer;
                }
            }
        }
        else if(userTypeLogin== Enums.UserTypeLogin.SELLER) {
            for (Seller seller : sellerList) {
                if (seller.getUserName().equals(userName) && seller.getPassWord().equals(password)) {
                    return seller;
                }
            }
        }
        else
        {
            Admin admin = Admin.getAdmin();
            if (admin.getUserName().equals(userName) && admin.getPassWord().equals(password)) {
                return admin;
            }
        }
        return null;
    }


}
