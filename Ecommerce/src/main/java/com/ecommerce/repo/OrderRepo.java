package com.ecommerce.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Order;

@Repository
public class OrderRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to add an order
    public void addOrder(int productId, int quantity, String status) {
        String sql = "INSERT INTO orders (product_id, quantity, status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, productId, quantity, status);
    }

    // Method to get all orders (optional for shipped page display)
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setProductId(rs.getInt("product_id"));
            order.setQuantity(rs.getInt("quantity"));
            order.setStatus(rs.getString("status"));
            return order;
        });
    }
}
