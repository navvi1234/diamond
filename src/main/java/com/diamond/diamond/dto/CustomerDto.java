package com.diamond.diamond.dto;

import java.util.Date;

import com.diamond.diamond.entity.CustomerEntity;
import com.diamond.diamond.entity.CustomerId;

public class CustomerDto {
	
	private String customerName;
	private String invoice;
	private Date selldate;
	private int ammount;
	private int leftAmmount;
	
	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String customerName, String invoice, Date selldate, int ammount,int leftAmmount) {
		super();
		this.customerName = customerName;
		this.invoice = invoice;
		this.selldate = selldate;
		this.ammount = ammount;
		this.leftAmmount=leftAmmount;
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

	

	@Override
	public String toString() {
		return "CustomerDto [customerName=" + customerName + ", invoice=" + invoice + ", selldate=" + selldate
				+ ", ammount=" + ammount + ", leftAmmount=" + leftAmmount + "]";
	}

	public CustomerEntity DtoToEntityCustomer(CustomerDto dto) {
		CustomerEntity customerEntity=new CustomerEntity();
//		CustomerId customerid=new CustomerId();
//		customerid.setCustomerName(dto.getCustomerName());
//		customerid.setInvoice(dto.getInvoice());
		customerEntity.setCustomerName(dto.getCustomerName());
		customerEntity.setInvoice(dto.getInvoice());
		customerEntity.setSelldate(dto.getSelldate());
		customerEntity.setAmmount(dto.getAmmount());
		customerEntity.setLeftAmmount(dto.getLeftAmmount());
		return customerEntity;
		
	}
	
	public CustomerDto EntityToDtoCustomer(CustomerEntity entity) {
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerName(entity.getCustomerName());
		customerDto.setInvoice(entity.getInvoice());
		customerDto.setSelldate(entity.getSelldate());
		customerDto.setAmmount(entity.getAmmount());
		customerDto.setLeftAmmount(entity.getLeftAmmount());
		
	    return customerDto;
		
		
	}
	
	
	
	

}
