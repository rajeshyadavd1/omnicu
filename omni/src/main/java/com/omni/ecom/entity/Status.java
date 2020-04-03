package com.omni.ecom.entity;

public enum Status {

	success("SUCCESS"),
	failed("FAILED");
	private final String status;

	private Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
}
