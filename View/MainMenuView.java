package View;

import Model.Enums;

import java.util.Scanner;

public class MainMenuView implements MainMenuViewInterface{
  Scanner input=new Scanner(System.in);
  public  void displayMainMenu()
  {
      System.out.println("SignUp");
      System.out.println("Login");
      System.out.println("Exit");
  }
  public  void userTypeLoginMenu()
  {
      System.out.println("Customer");
      System.out.println("Seller");
      System.out.println("Admin");
  }
    public  void userTypeSignUpMenu()
    {
        System.out.println("Customer");
        System.out.println("Seller");
    }
  public Enums.MainMenu mainMenuInputting()
  {
      displayMainMenu();
      String mainMenuInput=input.nextLine();
      mainMenuInput=mainMenuInput.toUpperCase();
      Enums.MainMenu process;
      try {
          process= Enums.MainMenu.valueOf(mainMenuInput);
      }
      catch(Exception e )
      {
          System.out.println("Enter a valid request");
          return mainMenuInputting();
      }
      return process;
  }
  public Enums.UserTypeLogin userTypeLoginInputting()
  {
      userTypeLoginMenu();
      Enums.UserTypeLogin userType;
      String user=input.nextLine();
      user=user.toUpperCase();
      try {
          userType= Enums.UserTypeLogin.valueOf(user);
      }
      catch(Exception e )
      {
          System.out.println("Enter a valid request");
          return userTypeLoginInputting();
      }
      return userType;
  }
    public Enums.UserTypeSignUp userTypeSignUpInputting()
    {
        userTypeSignUpMenu();
        Enums.UserTypeSignUp userType;
        String user=input.nextLine();
        user=user.toUpperCase();
        try {
            userType= Enums.UserTypeSignUp.valueOf(user);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return userTypeSignUpInputting();
        }
        return userType;
    }



}
