package com.diamond.diamond.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerName;
	private String invoice;
	
	public CustomerId() {
		super();
	}
	
	public CustomerId(String customerName, String invoice) {
		super();
		this.customerName = customerName;
		this.invoice = invoice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	
	
	
	
	
	

}
