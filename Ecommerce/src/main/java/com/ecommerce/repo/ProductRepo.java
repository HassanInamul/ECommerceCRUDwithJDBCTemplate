package com.ecommerce.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;

@Repository
public class ProductRepo {
	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public List<Product> getAllProducts() {
	        String sql = "SELECT * FROM product";
	        return jdbcTemplate.query(sql, (rs, rowNum) -> {
	            Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setName(rs.getString("name"));
	            product.setPrice(rs.getDouble("price"));
	            product.setStock(rs.getInt("stock"));
	            return product;
	        });
	    }

	    public void addProduct(Product product) {
	        String sql = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getStock());
	    }

	    public void updateProductStock(int productId, int quantity) {
	        String sql = "UPDATE product SET stock = stock - ? WHERE id = ?";
	        jdbcTemplate.update(sql, quantity, productId);
	    }
	    public Product getProductById(int productId) {
	        String sql = "SELECT * FROM product WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new BeanPropertyRowMapper<>(Product.class));
	    }
	}
