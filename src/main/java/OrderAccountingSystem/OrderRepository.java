package OrderAccountingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private String url = "jdbc:mysql://localhost:3306/javapolitech_j130_lab";
    private String user = "root";
    private String password = "root";

    public List<String> getOrderProductNames(int orderId) {
        List<String> productNames = new ArrayList<>();
        String query = "SELECT P.name, P.color FROM Products P " +
                "JOIN OrderItems OI ON P.sku = OI.sku " +
                "WHERE OI.order_id = " + orderId;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String color = resultSet.getString("color");
                if (color != null && !color.isEmpty()) {
                    name += " (" + color + ")";
                }
                productNames.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productNames;
    }

    public void printOrderProductNames(int orderId) {
        List<String> productNames = getOrderProductNames(orderId);
        for (String name : productNames) {
            System.out.println(name);
        }
    }
}

