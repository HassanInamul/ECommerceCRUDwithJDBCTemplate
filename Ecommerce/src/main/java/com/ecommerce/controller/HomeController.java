package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderService orderService;

    @RequestMapping({"/","home"})
    public String home() {
        return "home";
    }

    @RequestMapping("/viewProducts")
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "viewProducts";
    }

    @RequestMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/viewProducts";
    }

    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductbyID(id);
        System.out.println(product);
        model.addAttribute("product", product);
        return "cart";
    }

    @RequestMapping(value = "/buyNow", method = RequestMethod.POST)
    public String buyNow(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity, Model model) {
        productService.updateProductStock(productId, quantity);
        orderService.placeOrder(productId, quantity, "Shipped");
        Product shippedProduct = productService.getProductbyID(productId); // Use new method to get the product by ID
        model.addAttribute("shippedProduct", shippedProduct);
        model.addAttribute("quantity", quantity);
        return "shipped";
    }
    @RequestMapping("/shippedOrders")
    public String viewShippedOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "shippedOrders";
    }
}
