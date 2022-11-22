package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
public class Filter {
    ProductViewInterface productsView=new ProductsView();
    FilterViewInterface filterView=new FilterView();
    Server server = Server.getServer();
    public ArrayList<Product> applyFilters()
    {
        ArrayList<Product> filteredProductList=new ArrayList<>();
        Enums.FilterMenu filterType=filterView.filterMenuInputting();
        switch (filterType)
        {
            case TYPEOFPRODUCT:
                return filteringByProductType(filteredProductList);
           case PRICEOFTHEPRODUCT:
               return filteringByPrice(filteredProductList);
           case BRAND:
                return filteringByBrand(filteredProductList);

        }
        return filteredProductList;
    }
    public ArrayList<Product> filteringByProductType(ArrayList<Product> filteredProductList)
    {
        Enums.TypeOfProduct productType=productsView.typeOfProductMenuInputting();
        for(Product product:server.getProductList())
        {
            if(productType==product.getProductType())
            {
                filteredProductList.add(product);
            }
        }
        return filteredProductList;
    }
    public ArrayList<Product> filteringByPrice(ArrayList<Product> filteredProductList)
    {
        int fromPrice=filterView.fromPriceInputting();
        int toPrice=filterView.toPriceInputting();
        if(fromPrice>toPrice)
        {
            int temporary=fromPrice;
            fromPrice=toPrice;
            toPrice=temporary;
        }
        for(Product product:server.getProductList())
        {
            if(product.getPrice()>=fromPrice&&product.getPrice()<=toPrice)
            {
                filteredProductList.add(product);
            }
        }
        return filteredProductList;
    }
    public ArrayList<Product> filteringByBrand(ArrayList<Product> filteredProductList)
    {
        String brandName=filterView.brandInputting();
        for(Product product:server.getProductList())
        {
            if(brandName.equalsIgnoreCase(product.getBrandName()))
            {
                filteredProductList.add(product);
            }
        }
        return filteredProductList;
    }

}
