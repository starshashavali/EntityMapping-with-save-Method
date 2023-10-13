package com.sco.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sco.domain.Customer;
import com.sco.domain.OrderDtls;
import com.sco.domain.Product;
import com.sco.dto.OrderRequest;
import com.sco.dto.OrderResponse;
import com.sco.repo.OrderDtlRepo;
import com.sco.service.IOrderServicce;

@Service
public class IOrderServicceImpl  implements IOrderServicce{
	
	@Autowired
	private OrderDtlRepo  orderDtlRepo;

	@Override
	public OrderResponse saveOrder(OrderRequest orderDtlDTO) {
		
		OrderDtls entity=new OrderDtls();
		BeanUtils.copyProperties(orderDtlDTO, entity);
		Customer customer=new Customer();
		customer.setCustomerName(orderDtlDTO.getCustomer().getCustomerName());
		customer.setEmail(orderDtlDTO.getCustomer().getEmail());
		
		entity.setCustomer(customer);
		
		List<Product> listOfProducts=new ArrayList<>();
		for(Product product:orderDtlDTO.getProducts()) {
			listOfProducts.add(product);
		}
		entity.setProducts(listOfProducts);
		entity.setOrderStatus("Success");
		System.out.println(entity);
		OrderDtls entity1 = orderDtlRepo.save(entity);
		
		
		OrderResponse response=new OrderResponse();
		response.setEmail(entity1.getCustomer().getEmail());
		response.setCustomerName(entity1.getCustomer().getCustomerName());
		response.setOrderStatus(entity1.getOrderStatus());

		
		
		   // Set product names and prices to response
        List<String> productNames = new ArrayList<>();
        List<Double> productPrices = new ArrayList<>();
        for (Product product : entity1.getProducts()) {
            productNames.add(product.getProductName());
            productPrices.add(product.getPrice());
        }
        response.setProductName(productNames);
        response.setPrice(productPrices);
		
		
		return response;
	}

}
