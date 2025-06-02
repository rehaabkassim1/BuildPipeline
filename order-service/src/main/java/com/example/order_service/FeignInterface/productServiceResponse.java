package com.example.order_service.FeignInterface;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class productServiceResponse {
	private ProductDTO response;
    private String resultCode;
    private String resultMessage;
    
}
