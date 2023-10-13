package com.sco.service;

import com.sco.dto.OrderRequest;
import com.sco.dto.OrderResponse;

public interface IOrderServicce {
	
	public OrderResponse saveOrder(OrderRequest orderDtlDTO);

}
