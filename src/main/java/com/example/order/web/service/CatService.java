package com.example.order.web.service;

import java.util.ArrayList;

import com.example.order.web.model.Category;

public interface CatService {

	void insert(Category cat);
	void delete(int id);
	ArrayList<Category> getAllCategory();

}
