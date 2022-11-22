package View;

import Model.Enums;

public interface FilterViewInterface
{
     void displayFilterMenu();
     Enums.FilterMenu filterMenuInputting();
     String brandInputting();
     int fromPriceInputting();
     int toPriceInputting();

}
