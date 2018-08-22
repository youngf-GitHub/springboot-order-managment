package com.example.order.web;

import org.springframework.data.repository.CrudRepository;

import com.example.order.web.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
