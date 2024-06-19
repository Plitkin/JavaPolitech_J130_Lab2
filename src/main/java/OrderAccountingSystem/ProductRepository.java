package OrderAccountingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private String url = "jdbc:mysql://localhost:3306/javapolitech_j130_lab";
    private String user = "root";
    private String password = "root";

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Products")) {

            while (resultSet.next()) {
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                String color = resultSet.getString("color");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                Product product = new Product(sku, name, color, price, stock);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public void printAllProducts() {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

