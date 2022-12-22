package com.diamond.diamond.dto;

import java.util.Date;

public class CustomerUpdateDto {
	private String customerName;
	private String invoice;
	private Date selldate;
	private int ammount;
	private int leftAmmount;
	private String newInvoice;
	
	public CustomerUpdateDto() {
		// TODO Auto-generated constructor stub
	}
	public CustomerUpdateDto(String customerName, String invoice, Date selldate, int ammount, int leftAmmount,
			String newInvoice) {
		super();
		this.customerName = customerName;
		this.invoice = invoice;
		this.selldate = selldate;
		this.ammount = ammount;
		this.leftAmmount = leftAmmount;
		this.newInvoice = newInvoice;
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
	public Date getSelldate() {
		return selldate;
	}
	public void setSelldate(Date selldate) {
		this.selldate = selldate;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public int getLeftAmmount() {
		return leftAmmount;
	}
	public void setLeftAmmount(int leftAmmount) {
		this.leftAmmount = leftAmmount;
	}
	public String getNewInvoice() {
		return newInvoice;
	}
	public void setNewInvoice(String newInvoice) {
		this.newInvoice = newInvoice;
	}
	
	
	

}
