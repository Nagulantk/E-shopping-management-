package View;

import Model.Enums;

public interface MainMenuViewInterface
{
     void displayMainMenu();
     void userTypeLoginMenu();
     void userTypeSignUpMenu();
     Enums.MainMenu mainMenuInputting();
     Enums.UserTypeLogin userTypeLoginInputting();
     Enums.UserTypeSignUp userTypeSignUpInputting();
}
