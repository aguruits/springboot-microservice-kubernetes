package com.ecomm;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ecomm.entity.Order;
import com.ecomm.repository.OrderRepository;

@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication {

	@Autowired
	private OrderRepository orderRepository;

	@PostConstruct
	public void initOrdersTable() {
		orderRepository.saveAll(Stream
				.of(new Order("mobile", "electronics", "white", 20000), new Order("T-Shirt", "clothes", "black", 999),
						new Order("Jeans", "clothes", "blue", 1999), new Order("Laptop", "electronics", "gray", 50000),
						new Order("digital watch", "electronics", "black", 2500),
						new Order("Fan", "electronics", "black", 50000))
				.collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
