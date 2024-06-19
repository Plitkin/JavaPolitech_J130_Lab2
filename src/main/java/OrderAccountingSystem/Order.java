package OrderAccountingSystem;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date creationDate;
    private String customerName;
    private String contactPhone;
    private String email;
    private String deliveryAddress;
    private char status;
    private Date shippingDate;
    private List<OrderItem> items;

    public Order(int orderId, Date creationDate, String customerName, String contactPhone, String email, String deliveryAddress, char status, Date shippingDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        this.customerName = customerName;
        this.contactPhone = contactPhone;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
        this.shippingDate = shippingDate;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public char getStatus() {
        return status;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

