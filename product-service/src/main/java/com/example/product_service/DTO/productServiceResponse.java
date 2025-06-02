package com.example.product_service.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class productServiceResponse {
	private Object response;
    private String resultCode;
    private String resultMessage;
    
}
