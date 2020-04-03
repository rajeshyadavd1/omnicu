package com.omni.ecom.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String pname;
	
	private BigDecimal price;
	
	private long qty;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String pname, BigDecimal price, long qty) {
		super();
		this.pname = pname;
		this.price = price;
		this.qty = qty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}
	
}
