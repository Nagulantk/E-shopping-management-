package Model;

import java.time.LocalDate;
import java.util.HashMap;

public class Order {
    private long OrderId;
    private HashMap<Product,Integer> productWithQuantityList;
    private int totalAmount;
    private float tax;
    private Address deliveryAddress;
    private LocalDate orderedDate;
    private LocalDate deliveryDate;
    public Order(long orderId, HashMap<Product,Integer> productList, int totalAmount, float tax, LocalDate orderedDate, LocalDate deliveryDate,Address deliveryAddress)
    {
        OrderId = orderId;
        this.productWithQuantityList = productList;
        this.totalAmount = totalAmount;
        this.tax = tax;
        this.orderedDate = orderedDate;
        this.deliveryDate = deliveryDate;
        this.deliveryAddress=deliveryAddress;
    }

    public long getOrderId() {
        return OrderId;
    }
    public HashMap<Product, Integer> getProductWithQuantityList()
    {
        return productWithQuantityList;
    }
    public int getTotalAmount() {
        return totalAmount;
    }
    public float getTax() {
        return tax;
    }
    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }


}
