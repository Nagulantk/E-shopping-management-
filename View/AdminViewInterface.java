package View;

import Model.Enums;

public interface AdminViewInterface {
     Enums.AdminMenu adminMenuInputting();
     void displayAdminMenu();
     void displayVerifyProductMenu();
     void displayConditionMenu();
     Enums.Condition conditionMenuInputting();
     void verifyProductResult(boolean condition);

}
