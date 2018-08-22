package com.example.order.web.service;

import java.util.ArrayList;

import com.example.order.web.model.Category;
import com.example.order.web.model.Order;
import com.example.order.web.model.Product;

public interface ApplicationService {

	void insertCategory(Category cat);
	void deleteCategory(int id);
	void updateCategory(Category cat);
	ArrayList<Category> getAllCategory();
	Category getCategoryById(int id);

	void insertProduct(Product product);
	void deleteProduct(int id);
	void updateProduct(Product product);
	ArrayList<Product> getAllProduct();
	Product getProductById(int id);

	void insertOrder(Order order);
	void deleteOrder(int id);
	void updateOrder(Order order);
	ArrayList<Order> getAllOrder();
	Order getOrderById(int id);
}
