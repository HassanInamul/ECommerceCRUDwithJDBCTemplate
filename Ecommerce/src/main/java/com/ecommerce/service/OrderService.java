package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Order;
import com.ecommerce.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderDAO;

    // Method to add an order
    public void placeOrder(int productId, int quantity, String status) {
        orderDAO.addOrder(productId, quantity, status);
    }

    // Optionally, method to retrieve all orders (for displaying on shipped page)
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}
