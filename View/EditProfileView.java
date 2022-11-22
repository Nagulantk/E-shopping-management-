package View;
import Model.Enums;
import java.util.Scanner;
public class EditProfileView implements EditProfileViewInterface {
    Scanner input=new Scanner(System.in);
    public void displayEditProfileMenu()
    {
        System.out.println("Enter the details to be edited");
        System.out.println("Username");
        System.out.println("Password");
        System.out.println("Phone number");
        System.out.println("Gender");
        System.out.println("EmailId");
        System.out.println("Address");
    }
    public Enums.EditProfileMenu editProfileMenuInputting()
    {
        displayEditProfileMenu();
        String editProfileMenuInput=input.nextLine();
        editProfileMenuInput=editProfileMenuInput.toUpperCase();
        Enums.EditProfileMenu process;
        try {
            process= Enums.EditProfileMenu.valueOf(editProfileMenuInput);
        }
        catch(Exception e )
        {
            System.out.println("Enter a valid request");
            return editProfileMenuInputting();
        }
        return process;
    }

    public void editProfileResult()
    {
        System.out.println("Profile is edited SuccessFully");
    }

}
