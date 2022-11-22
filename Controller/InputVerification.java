package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerification{

    public boolean verifyUserName(String name)
    {
        String regex = "^[A-Za-z]\\w{5,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public boolean verifyString(String name)
    {
        String regex = "^[A-Za-z]\\w{2,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public boolean verifyEmailID(String emailID)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailID);
        return matcher.matches();
    }
    public boolean verifyPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public boolean verifyPhoneNumber(long phoneNumber)
    {
        String regex = "^\\d{10}$";
        String number=String.valueOf(phoneNumber);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public boolean verifyPinCode(long pinCode)
    {
        String regex = "^\\d{6}$";
        String number=String.valueOf(pinCode);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public boolean verifyAadhaarNumber(long aadhaarNumber)
    {
        String regex = "^\\d{12}$";
        String number=String.valueOf(aadhaarNumber);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public boolean verifyOffer(int Offer)
    {
        String regex = "^(100|[1-9]?[0-9])$";
        String number=String.valueOf(Offer);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

}


