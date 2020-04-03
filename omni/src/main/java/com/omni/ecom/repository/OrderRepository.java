package com.omni.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omni.ecom.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
