package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
public class CustomerLogin {
    LoginViewInterface loginView=new LoginView();
    Server server=Server.getServer();
    CustomerViewInterface customerView=new CustomerView();
    SelectProductViewInterface selectProduct=new SelectProductView();
    Filter filter=new Filter();
    BackGroundProcess backGroundProcess=new BackGroundProcess();
    ProductViewInterface productsView=new ProductsView();
    CartViewInterface cart=new CartView();
    PlaceOrder placeOrder=new PlaceOrder();
    OrderViewInterface orderView=new OrderView();
    public void customerLoggingIn(Enums.UserTypeLogin userTypeLogin)
    {
        Customer customer= (Customer) backGroundProcess.loginDetailsValidate(loginView.userNameInputting(),loginView.passWordInputting(),userTypeLogin);
        loginView.loginStatus(customer);
        boolean customerCondition=true;
        if(customer!=null)
        {
            productsView.customerProductView(server.getProductList());
         while (customerCondition) {
            Enums.CustomerMenu customerInput=customerView.customerInputting();
            switch (customerInput) {
                case VIEWPROFILE:
                    customerView.customerDetailsDisplay(customer);
                    break;
                case EDITPROFILE:
                    backGroundProcess.profileEditing(customer);
                    break;

                case SELECTPRODUCT:
                    productsView.customerProductView(server.getProductList());
                    selectingProduct(customer);
                    break;
                case APPLYFILTERS:
                    productsView.customerProductView(filter.applyFilters());
                    break;

                case OPENCART:
                    ArrayList<Product> cartProductList = customer.getCart().getProductList();
                    productsView.customerProductView(cartProductList);
                    Enums.CartMenu cartMenuInput = cart.cartMenuInputting();
                    switch (cartMenuInput) {
                        case PLACEORDER:
                             placeOrder.placingOrder(cartProductList, customer);
                             customer.setCart(new Cart());
                            break;
                        case REMOVEPRODUCTFROMCART:
                            removingProduct(cartProductList, customer);
                            break;
                    }
                    break;
                case DISPLAYPREVIOUSORDERS:
                    if(customer.getOrders().size()!=0) {
                        for (Order order : customer.getOrders()) {
                            orderView.displayOrderDetails(order);
                        }
                    }
                    else {
                        orderView.displayOrderResult();
                    }
                    break;
                case LOGOUT:
                    customerCondition = false;
                    break;
            }
            }
        }
    }
    public void selectingProduct(Customer customer)
    {
        Product selectedProduct=null;
        int productID=selectProduct.selectingProduct();
        boolean selectProductCondition=false;
        for(Product products:server.getProductList())
        {
            if(products.getProductID()==productID)
            {
                productsView.viewProduct(products);
                selectProductCondition=true;
                selectedProduct=products;
                break;
            }
        }
        selectProduct.displaySelectProductResult(selectProductCondition);
        if(selectProductCondition)
        {
            Enums.SelectProductMenu selectProductInput = selectProduct.selectProductMenuInputting();
            if (selectProductInput == Enums.SelectProductMenu.ADDPRODUCTTOCART) {
                customer.getCart().setProductList(selectedProduct);
                selectProduct.displayAddingProductToCartResult();
            }
        }
    }
    public void removingProduct(ArrayList<Product> cartProductList,Customer customer)
    {
        int productID=cart.selectingProduct();
        boolean cartCondition=false;
        for(Product product:server.getProductList())
        {
            if(product.getProductID()==productID)
            {
                cartProductList.remove(product);
                customer.getCart().setProductList(cartProductList);
                 cartCondition=true;
            }
        }
        cart.displayAddingProductToCartResult(cartCondition);
    }
}