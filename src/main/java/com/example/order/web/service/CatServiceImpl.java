package com.example.order.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.web.model.Category;

@Service
public class CatServiceImpl implements CatService {

	@Autowired
	CatService dao;

	@Override
	public void insert(Category cat) {
		dao.insert(cat);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public ArrayList<Category> getAllCategory() {
		return dao.getAllCategory();
	}
}
