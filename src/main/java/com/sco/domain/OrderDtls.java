package com.sco.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	private String orderStatus;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_fk")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_fk")
	private List<Product> products;

}
