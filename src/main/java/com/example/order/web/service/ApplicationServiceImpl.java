package com.example.order.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.web.CategoryRepository;
import com.example.order.web.OrderRepository;
import com.example.order.web.ProductRepository;
import com.example.order.web.model.Category;
import com.example.order.web.model.Order;
import com.example.order.web.model.Product;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	CategoryRepository catRepo;
	@Autowired
	ProductRepository prdRepo;
	@Autowired
	OrderRepository orderRepo;

	@Override
	public void insertCategory(Category cat) {
		catRepo.save(cat);
	}

	@Override
	public void deleteCategory(int id) {

		for (Product p : (ArrayList<Product>)prdRepo.findAll()) {
			if (p.getCatid() != id) {
				continue;
			}
			for (Order o : (ArrayList<Order>)orderRepo.findAll()) {
				if (o.getPrdid() != p.getId()) {
					continue;
				}
				orderRepo.deleteById(o.getId());
			}
			prdRepo.deleteById(p.getId());
		}
		catRepo.deleteById(id);
	}

	@Override
	public ArrayList<Category> getAllCategory() {
		return (ArrayList<Category>)catRepo.findAll();
	}

	@Override
	public void insertProduct(Product product) {
		prdRepo.save(product);
	}

	@Override
	public void deleteProduct(int id) {

		for (Order o : (ArrayList<Order>)orderRepo.findAll()) {
			if (o.getPrdid() != id) {
				continue;
			}
			orderRepo.deleteById(o.getId());
		}

		prdRepo.deleteById(id);
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		return (ArrayList<Product>)prdRepo.findAll();
	}

	@Override
	public void insertOrder(Order order) {
		orderRepo.save(order);
	}

	@Override
	public void deleteOrder(int id) {
		orderRepo.deleteById(id);
	}

	@Override
	public ArrayList<Order> getAllOrder() {
		return (ArrayList<Order>)orderRepo.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return catRepo.findById(id).get();
	}

	@Override
	public Product getProductById(int id) {
		return prdRepo.findById(id).get();
	}

	@Override
	public Order getOrderById(int id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public void updateCategory(Category cat) {
		catRepo.save(cat);
	}

	@Override
	public void updateProduct(Product product) {
		prdRepo.save(product);
	}

	@Override
	public void updateOrder(Order order) {
		orderRepo.save(order);
	}
}
