package com.omni.ecom.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omni.ecom.dto.ItemDto;
import com.omni.ecom.entity.Item;
import com.omni.ecom.other.ItemConverter;
import com.omni.ecom.service.ItemService;

@RestController
@RequestMapping("/omnicuris/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemConverter itemConverter;

	@GetMapping("/all")
	public ResponseEntity<List<ItemDto>> getAllItems(){
		
		Iterable<Item> items= itemService.getAllItems();
		return new ResponseEntity<List<ItemDto>>(IterableUtils.toList(items).stream().map(product -> itemConverter.convertToDto(product)).collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> findItem(@PathVariable(required=true) Long id){
		if(!itemService.existById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item with id "+id+" not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(itemConverter.convertToDto(itemService.findById(id)));
	}
	
	@PostMapping("/save")
	public ResponseEntity<ItemDto> saveItem(@RequestBody(required=true) Item item){
		return new ResponseEntity<ItemDto>(itemConverter.convertToDto(itemService.saveItem(item)), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateItem(@PathVariable(required=true) Long id, @RequestBody(required=true) Item item){
		if(!itemService.existById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item with id "+id+" not found.");
		}
		item.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(itemConverter.convertToDto(itemService.updateItem(item)));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteItem(@PathVariable(required=true) Long id){
		if(!itemService.existById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item with id "+id+" not found.");
		}
		itemService.deleteById(id);
		if(itemService.existById(id)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deletion unsuccessfull."); 
		}
		return ResponseEntity.status(HttpStatus.OK).body("item with id "+id+" deleted successfully.");
	}

}
