package com.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.entity.Order;
import com.ecomm.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {

    @Autowired
    private OrderRepository orderRepository;


	@GetMapping("/orderList")
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	@GetMapping("/getOrdersByCategory/{category}")
	public List<Order> getOrdersByCategory(@PathVariable String category){
		return orderRepository.findByCategory(category);
	}
	
	@GetMapping("/getOrdersById/{id}")
	public Order getOrdersById(@PathVariable int id){
		
		Optional<Order> order = orderRepository.findById(id); 
		return order.orElse(new Order("default","default", "default", 0));
	}

}
