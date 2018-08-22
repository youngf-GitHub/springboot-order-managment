package com.example.order.web;

import org.springframework.data.repository.CrudRepository;

import com.example.order.web.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
