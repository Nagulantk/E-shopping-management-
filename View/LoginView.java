package View;
import Model.User;
import java.util.Scanner;

public class LoginView implements LoginViewInterface{
    Scanner input=new Scanner(System.in);
    public void loginStatus(User user)
    {
        if(user!=null)
        {
            System.out.println("Login SuccessFull");
        }
        else {
            System.out.println("Login UnSuccessFull");
            System.out.println("Enter valid details");
        }
    }
    public String userNameInputting()
    {
        System.out.println("Enter user name:");
        return input.nextLine();
    }
    public String passWordInputting()
    {
        System.out.println("Enter password");
        return input.nextLine();
    }
}
