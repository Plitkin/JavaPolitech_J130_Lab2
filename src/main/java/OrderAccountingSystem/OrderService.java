package OrderAccountingSystem;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class OrderService {
    private String url = "jdbc:mysql://localhost:3306/javapolitech_j130_lab";
    private String user = "root";
    private String password = "root";

    public void registerOrder(String customerName, String contactPhone, String email, String deliveryAddress, List<OrderItem> items) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false);

            // Проверка наличия артикулов в таблице Products
            for (OrderItem item : items) {
                if (!isProductExists(connection, item.getSku())) {
                    throw new SQLException("Product with SKU " + item.getSku() + " does not exist.");
                }
            }

            String orderQuery = "INSERT INTO Orders (creation_date, customer_name, contact_phone, email, delivery_address, status) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement orderStatement = connection.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS)) {
                orderStatement.setDate(1, new java.sql.Date(new Date().getTime()));
                orderStatement.setString(2, customerName);
                orderStatement.setString(3, contactPhone);
                orderStatement.setString(4, email);
                orderStatement.setString(5, deliveryAddress);
                orderStatement.setString(6, "P");
                orderStatement.executeUpdate();

                try (ResultSet generatedKeys = orderStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int orderId = generatedKeys.getInt(1);

                        String itemQuery = "INSERT INTO OrderItems (order_id, sku, price, quantity) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement itemStatement = connection.prepareStatement(itemQuery)) {
                            for (OrderItem item : items) {
                                itemStatement.setInt(1, orderId);
                                itemStatement.setString(2, item.getSku());
                                itemStatement.setInt(3, item.getPrice());
                                itemStatement.setInt(4, item.getQuantity());
                                itemStatement.executeUpdate();
                            }
                        }
                    } else {
                        throw new SQLException("Creating order failed, no ID obtained.");
                    }
                }
            }

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isProductExists(Connection connection, String sku) throws SQLException {
        String query = "SELECT COUNT(*) FROM Products WHERE sku = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, sku);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
