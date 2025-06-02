package com.example.product_service.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.product_service.DTO.productServiceResponse;
import com.example.product_service.DTO.ProductDTO;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repo;

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	public ResponseEntity<?> getProductById(Long Id){	
		Optional<Product> productbyId = repo.findById(Id);
		System.out.println("getProductById"+Id);
		productbyId = Optional.of(new Product(1L, "Hello", "Hello", 0));
		System.out.println("getProductById"+productbyId.isPresent());
		if(productbyId.isPresent()) {
			Product product = productbyId.get();
			System.out.println("getProductById"+product);
			
			productServiceResponse response = productServiceResponse.builder().response(ProductDTO.builder()
			.id(product.getId())
			.name(product.getName())
			.description(product.getDescription())
			.price(product.getPrice()).build()).resultCode("200").resultMessage("Success").build();
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			productServiceResponse modifiedAPIResponse = productServiceResponse.builder().resultCode("404").resultMessage("Resource Not Found").build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(modifiedAPIResponse);
		}
		
	}
	
	
	

}
