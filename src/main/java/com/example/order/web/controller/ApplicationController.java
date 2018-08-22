package com.example.order.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.order.web.model.Category;
import com.example.order.web.model.Order;
import com.example.order.web.model.Product;
import com.example.order.web.service.ApplicationService;

@Controller
public class ApplicationController {

	@Autowired
	private ApplicationService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView model = new ModelAndView();
		ArrayList<Category> clist = service.getAllCategory();
		ArrayList<Product> plist = service.getAllProduct();
		ArrayList<Order> olist = service.getAllOrder();

		model.setViewName("list_view");
		model.addObject("cat_list", clist);
		model.addObject("prd_list", plist);
		model.addObject("order_list", olist);

		return model;
	}






	@RequestMapping(value = "/cat/{id}", method = RequestMethod.GET)
	public ModelAndView editCat(@PathVariable int id) {

		ModelAndView model = new ModelAndView("cat_edit_view");
		Category category = service.getCategoryById(id);
		model.addObject("cat", category);
		model.setViewName("cat_edit_view");

		return model;
	}

	@RequestMapping(value = "/cat/save", method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("cat") Category category) {

		service.updateCategory(category);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/cat/add", method = RequestMethod.GET)
	public ModelAndView addCategory(@ModelAttribute("cat") Category cat) {

		ModelAndView model = new ModelAndView("cat_edit_view");
		Category category = new Category();
		model.addObject("cat", category);
		model.setViewName("cat_edit_view");

		return model;
	}

	@RequestMapping(value = "/cat/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("id") int id) {

		service.deleteCategory(id);
		return new ModelAndView("redirect:/");
	}






	@RequestMapping(value = "/prd/{id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id) {

		ModelAndView model = new ModelAndView("prd_edit_view");
		Product product = service.getProductById(id);
		model.addObject("prd", product);
		return model;
	}

	@RequestMapping(value = "/prd/save", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("prd") Product product) {

		service.updateProduct(product);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/prd/add", method = RequestMethod.GET)
	public ModelAndView addCategory(@ModelAttribute("prd") Product prd) {

		ModelAndView model = new ModelAndView("prd_edit_view");
		Product product = new Product();
		model.addObject("prd", product);

		return model;
	}

	@RequestMapping(value = "/prd/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("id") int id) {

		service.deleteProduct(id);
		return new ModelAndView("redirect:/");
	}






	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ModelAndView editOrder(@PathVariable int id) {
		ModelAndView model = new ModelAndView("order_edit_view");
		Order order = service.getOrderById(id);
		model.addObject("order", order);
		return model;
	}

	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	public ModelAndView saveOrder(@ModelAttribute("order") Order order) {

		service.updateOrder(order);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/order/add", method = RequestMethod.GET)
	public ModelAndView addCategory(@ModelAttribute("order") Order Order) {

		ModelAndView model = new ModelAndView("order_edit_view");
		Order o = new Order();
		model.addObject("order", o);

		return model;
	}

	@RequestMapping(value = "/order/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteOrder(@PathVariable("id") int id) {

		service.deleteOrder(id);
		return new ModelAndView("redirect:/");
	}


}
