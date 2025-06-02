package com.example.order_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;



    public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	/*
	 * @GetMapping public List<Order> getAll() { return orderService.findAll(); }
	 * 
	 * @PostMapping public Order create(@RequestBody Order order) {
	 * order.setOrderDate(LocalDateTime.now()); return orderService.save(order); }
	 */
    
    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestParam(name = "product_id") Long productId, @RequestParam(name="quantity") int quantity){
		Order placeOrder = orderService.placeOrder(productId, quantity);
		System.out.println(placeOrder.toString());
    	return ResponseEntity.ok(placeOrder);
    	
    }
}
