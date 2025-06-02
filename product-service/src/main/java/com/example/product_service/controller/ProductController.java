package com.example.product_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	/*
	 * @GetMapping public List<Product> getAll() { return repo.findAll(); }
	 * 
	 * @PostMapping public Product create(@RequestBody Product product) { return
	 * repo.save(product); }
	 */

	@GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long Id) {
    	System.out.println("inside get");

		ResponseEntity<?> productbyId = productService.getProductById(Id);
        
		return productbyId;
    }
}
