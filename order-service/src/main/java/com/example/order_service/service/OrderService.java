package com.example.order_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.order_service.FeignInterface.ProductClient;
import com.example.order_service.FeignInterface.ProductDTO;
import com.example.order_service.FeignInterface.productServiceResponse;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

@Service
public class OrderService {
	
	private final ProductClient productClient;
	private final OrderRepository orderRepository;


	
	public OrderService(ProductClient productClient, OrderRepository orderRepository) {
		super();
		this.productClient = productClient;
		this.orderRepository = orderRepository;
	}



	public Order placeOrder(Long productId,int quantity) {
		productServiceResponse product = productClient.getProductById(productId);
		System.out.println(product);
		Order order = new Order();
		System.out.println("before invoking");
		ProductDTO dto = (ProductDTO) product.getResponse();
		System.out.println(dto);
		order.setProductName(dto.getName());
		order.setOrderDate(LocalDateTime.now());
		order.setQuantity(quantity);
		
		return orderRepository.save(order);
	}
}
