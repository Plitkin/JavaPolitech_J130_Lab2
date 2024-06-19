package OrderAccountingSystem;

public class OrderItem {
    private int orderId;
    private String sku;
    private int price;
    private int quantity;

    public OrderItem(int orderId, String sku, int price, int quantity) {
        this.orderId = orderId;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId=" + orderId +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

