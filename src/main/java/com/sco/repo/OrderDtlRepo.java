package com.sco.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sco.domain.OrderDtls;

public interface OrderDtlRepo extends JpaRepository<OrderDtls, Integer>{

}
