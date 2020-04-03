package com.omni.ecom.other;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omni.ecom.dto.ItemDto;
import com.omni.ecom.entity.Item;

@Component
public class ItemConverter {

	@Autowired
	ModelMapper modelMapper;
	
	public ItemDto convertToDto(Item product) {		
		return modelMapper.map(product, ItemDto.class);
	}
	
	public Item convertToModel(ItemDto productDto) {
		return modelMapper.map(productDto, Item.class);
	}
}
