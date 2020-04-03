package com.omni.ecom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omni.ecom.entity.Item;
import com.omni.ecom.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository ir;
	
	public Item saveItem(Item item) {
		
		return ir.save(item);
	}
	
	public Item findById(Long id) {
	
		return ir.findById(id).get();
	}
	
	public Iterable<Item> getAllItems(){
		
		return ir.findAll();
	}
	
	public Item updateItem(Item item) {
		
		Optional<Item> i=ir.findById(item.getId());
		if(i.isPresent()) {
			Item item1=i.get();
		}
		return ir.save(item);
	}
	
	public boolean existById(Long id) {
		
		return ir.existsById(id);
	}
	
	public void deleteById(Long id) {
		
		ir.deleteById(id);
	}
	
}
