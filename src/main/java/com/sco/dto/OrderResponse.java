package com.sco.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	
	private List<String> productName;
	
	private String customerName;


	private String email;
	
	private List<Double> price;
	
	private String orderStatus;
	
	
}
