package View;

import Controller.InputVerification;
import Model.Enums;

import java.util.Scanner;

public class SignUpView implements SignUpViewInterface{

    Scanner input=new Scanner(System.in);
    InputVerification inputVerification=new InputVerification();
    public String userNameInputting()
    {
        boolean condition=false;
        System.out.println("Enter user name");
        String userName=null;
        while(!condition)
        {
            userName=input.nextLine();
            condition=inputVerification.verifyUserName(userName);
            if(!condition)
            {
                System.out.println("Enter a valid user name");
            }
        }
        return userName;
    }
    public long phoneNumberInputting()
    {
        boolean condition=false;
        long phoneNumber=0;
        while (!condition)
        {
            phoneNumber=UserInputValidation.longValidation("Phone Number");
            condition=inputVerification.verifyPhoneNumber(phoneNumber);
            if(!condition)
            {
                System.out.println("Enter a valid Phone Number");
                System.out.println("Phone number must be of 10 digits");
            }
        }
        return phoneNumber;
    }
    public void genderMenu()
    {
        System.out.println("Enter gender:");
        System.out.println("Male");
        System.out.println("Female");
        System.out.println("Prefer not to say");
    }
    public Enums.Gender genderInputting()
    {   genderMenu();
        String genderMenuInput=input.nextLine();
        genderMenuInput=genderMenuInput.toUpperCase();
        Enums.Gender process;
        try {
            process= Enums.Gender.valueOf(genderMenuInput);
        }
        catch(Exception e)
        {
            System.out.println("Enter a valid request");
            return genderInputting();
        }
        return process;
    }
    public String emailInputting()
    {
        System.out.println("Enter email Id");
        String emailId=null;
        boolean condition=false;
        while (!condition)
        {
            emailId=input.nextLine();
            condition=inputVerification.verifyEmailID(emailId);
            if(!condition)
            {
                System.out.println("Enter a valid Email ID");
            }
        }
        return emailId;
    }
    public String passwordInputting()
    {
        String password=null,reEnteredPassword;
        do
        {
            boolean condition=false;
            while (!condition)
            {
                System.out.println("Enter password");
                password=input.nextLine();
                condition=inputVerification.verifyPassword(password);
                if(!condition)
                {
                    System.out.println("Enter a valid Password");
                    System.out.println("Password must be atLeast have 8 characters with atLeast 1 number,1 lower case letter,1 upper case letter,1 special symbol ");
                }
            }
            System.out.println("ReEnter password");
            reEnteredPassword=input.nextLine();
            if(!password.equals(reEnteredPassword))
            {
                System.out.println("Re entered password is not same as the password");
            }
        }while (!password.equals(reEnteredPassword));
        return password;
    }
    public long aadhaarNumberInputting()
    {
        boolean condition=false;
        long aadhaarNumber=0;
        while (!condition)
        {
            aadhaarNumber=UserInputValidation.longValidation("AadhaarNumber");
            condition=inputVerification.verifyAadhaarNumber(aadhaarNumber);
            if(!condition)
            {
                System.out.println("Enter a valid Aadhaar Number");
                System.out.println("Aadhaar number must be of 12 digits");
            }
        }
        return aadhaarNumber;
    }
    public int flatNumberInputting()
    {
        return UserInputValidation.intValidation("Flat number");
    }
    public String streetNameInputting()
    {
        System.out.println("Enter street name");
        boolean condition=false;
        String streetName=null;
        while(!condition)
        {
            streetName=input.nextLine();
            condition=inputVerification.verifyString(streetName);
            if(!condition)
            {
                System.out.println("Enter a valid street name");
            }
        }

        return streetName;
    }
    public String townNameInputting()
    {
        System.out.println("Enter town name");
        boolean condition=false;
        String townName=null;
        while(!condition)
        {
            townName=input.nextLine();
            condition=inputVerification.verifyString(townName);
            if(!condition)
            {
                System.out.println("Enter a valid town name");
            }
        }

        return townName;
    }
    public String districtNameInputting()
    {
        System.out.println("Enter district name");
        boolean condition=false;
        String districtName=null;
        while(!condition)
        {
            districtName=input.nextLine();
            condition=inputVerification.verifyString(districtName);
            if(!condition)
            {
                System.out.println("Enter a valid district name");
            }
        }

        return districtName;
    }
    public String stateNameInputting()
    {
        System.out.println("Enter state name");
        boolean condition=false;
        String stateName=null;
        while(!condition)
        {
            stateName=input.nextLine();
            condition=inputVerification.verifyString(stateName);
            if(!condition)
            {
                System.out.println("Enter a valid state name");
            }
        }

        return stateName;

    }
    public int pinCodeInputting()
    {
        boolean condition=false;
        int pinCode=0;
        while(!condition)
        {
             pinCode = UserInputValidation.intValidation("Pin code");
            condition=inputVerification.verifyPinCode(pinCode);
            if(!condition)
            {
                System.out.println("Enter a valid pin code");
            }
        }
        return pinCode;
    }
    public void uniquePhoneNumberValidateResult()
    {
        System.out.println("This phone number is already registered.");
        System.out.println("Please enter another phone number");
    }
}
