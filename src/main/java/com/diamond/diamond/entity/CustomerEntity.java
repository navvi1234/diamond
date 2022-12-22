package com.diamond.diamond.entity;



import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class CustomerEntity {
	
//	@EmbeddedId
//	private CustomerId customerId;
	@Id
	private String invoice;
	
	private String customerName;
	
	private Date selldate;
	
	private int ammount;
	private int leftAmmount;
 
	public CustomerEntity() {
		super();
	}

	
	public CustomerEntity(String invoice, String customerName, Date selldate, int ammount, int leftAmmount) {
		super();
		this.invoice = invoice;
		this.customerName = customerName;
		this.selldate = selldate;
		this.ammount = ammount;
		this.leftAmmount = leftAmmount;
	}


	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	
	
	
	
	
	
	
	
	

}
