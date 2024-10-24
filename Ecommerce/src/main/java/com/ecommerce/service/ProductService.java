package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productDAO;

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void updateProductStock(int productId, int quantity) {
        productDAO.updateProductStock(productId, quantity);
    }
    public Product getProductbyID(int id) {
		return productDAO.getProductById(id);
    }
}
