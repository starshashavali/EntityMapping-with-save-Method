package com.sco.dto;

import java.util.List;

import com.sco.domain.Customer;
import com.sco.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
	
	private Integer orderId;

	private String orderName;


	private Customer customer;


	private List<Product> products;

}
