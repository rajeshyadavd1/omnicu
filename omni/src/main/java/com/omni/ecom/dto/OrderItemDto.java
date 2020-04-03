package com.omni.ecom.dto;

import com.omni.ecom.entity.Item;

public class OrderItemDto {

	private Item product;
	
	private long qty;

	public Item getProduct() {
		return product;
	}

	public void setProduct(Item product) {
		this.product = product;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}
}
