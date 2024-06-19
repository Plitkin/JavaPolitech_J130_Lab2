package OrderAccountingSystem;

public class Product {
    private String sku;
    private String name;
    private String color;
    private int price;
    private int stock;

    public Product(String sku, String name, String color, int price, int stock) {
        this.sku = sku;
        this.name = name;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "OrderAccountingSystem.Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

