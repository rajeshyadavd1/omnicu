package com.omni.ecom.dto;

import com.omni.ecom.entity.Item;

public class OrderItemDto {

	private Item item;
	
	private long qty;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}
}
