package com.omni.ecom.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.ecom.dto.OrderDto;
import com.omni.ecom.dto.OrderItemDto;
import com.omni.ecom.entity.Order;
import com.omni.ecom.entity.Item;
import com.omni.ecom.entity.Status;
import com.omni.ecom.other.OrderConverter;
import com.omni.ecom.repository.OrderRepository;
import com.omni.ecom.repository.ItemRepository;

@Service
public class OrderService {

	@Autowired
	ItemRepository ir;
	
	@Autowired
	OrderRepository or;
	
	@Autowired
	OrderConverter oc;
	
	public Iterable<Order> findAllOrders(){
		
		return or.findAll();
	}
	
	public OrderDto placeOrders(List<OrderItemDto> opd, String custEmail) {
		
		OrderDto od=new OrderDto();
		Order order=new Order();
		long totalItems=0;
		BigDecimal totalAmount=new BigDecimal(0);
		for(OrderItemDto opd1:opd) {
			Item item=opd1.getProduct();
			long qty=opd1.getQty();
			if(!ir.existsById(item.getId())) {
				od.setId(0L);
				od.setStatus(Status.failed.getStatus());
				od.setOrderTotal(new BigDecimal(0));
				od.setTotalItems(0);
				return od;
			}
			Item it=ir.findById(item.getId()).get();
			if(it.getQty()<qty) {
				od.setId(0L);
				od.setStatus(Status.failed.getStatus());
				od.setOrderTotal(new BigDecimal(0));
				od.setTotalItems(0);
				return od;
			}
			totalItems+=qty;
			totalAmount=totalAmount.add(it.getPrice()==null?new BigDecimal(0):(it.getPrice().multiply(new BigDecimal(qty))));
		}
		order.setCustEmail(custEmail);
		order.setOrderTotal(totalAmount);
		order.setTotalItems(totalItems);
		order.setStatus(Status.success.getStatus());
		
		Order placed=or.save(order);
		od=oc.convertToDto(placed);
		//pending converter
		return od;
	}
}
