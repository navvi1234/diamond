package com.diamond.diamond.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_details")
public class CreditEntity {

	@Id
	private String transactionId;
	private String customerName;
	private String invoice;
    private Date creditDate;
	private int creditAmmount;
	
	public CreditEntity() {
		// TODO Auto-generated constructor stub
	}

	public CreditEntity(String transactionId, String customerName, String invoice, Date creditDate, int creditAmmount) {
		super();
		this.transactionId = transactionId;
		this.customerName = customerName;
		this.invoice = invoice;
		this.creditDate = creditDate;
		this.creditAmmount = creditAmmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public Date getCreditDate() {
		return creditDate;
	}

	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}

	public int getCreditAmmount() {
		return creditAmmount;
	}

	public void setCreditAmmount(int creditAmmount) {
		this.creditAmmount = creditAmmount;
	}
	
	
}
