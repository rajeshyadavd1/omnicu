package com.omni.ecom.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omni.ecom.dto.OrderDto;
import com.omni.ecom.dto.OrderItemDto;
import com.omni.ecom.entity.Order;
import com.omni.ecom.entity.Status;
import com.omni.ecom.other.OrderConverter;
import com.omni.ecom.service.OrderService;

@RestController
@RequestMapping("/omnicuris/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderConverter orderConverter;
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderDto>> findAllOrder(){
		Iterable<Order> allOrders= orderService.findAllOrders();
		return new ResponseEntity<List<OrderDto>>(IterableUtils.toList(allOrders).stream().map(order -> orderConverter.convertToDto(order)).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PostMapping("/place/{custEmail}")
	public ResponseEntity<OrderDto> placeOrder(@PathVariable String custEmail,@RequestBody List<OrderItemDto> orderItemData){
		
		OrderDto orderDto= orderService.placeOrders(orderItemData, custEmail);
		if(orderDto.getStatus().equals(Status.failed.getStatus())) {
			return ResponseEntity.badRequest().body(orderDto);
		}		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
	}

}
