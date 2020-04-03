package com.omni.ecom.other;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omni.ecom.dto.OrderDto;
import com.omni.ecom.entity.Order;

@Component
public class OrderConverter {

	@Autowired
	ModelMapper mm;
	
	public OrderDto convertToDto(Order order) {		
		return mm.map(order, OrderDto.class);
	}

}
