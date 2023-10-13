package com.sco.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sco.dto.OrderRequest;
import com.sco.dto.OrderResponse;
import com.sco.service.IOrderServicce;

@RestController
public class OrderRestController {
	
	@Autowired
	IOrderServicce  iorderServicce;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<?> saveOrder(@RequestBody OrderRequest request){
		OrderResponse order = iorderServicce.saveOrder(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

}
