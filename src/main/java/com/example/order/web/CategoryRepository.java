package com.example.order.web;

import org.springframework.data.repository.CrudRepository;

import com.example.order.web.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
