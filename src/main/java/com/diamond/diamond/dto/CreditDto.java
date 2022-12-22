package com.diamond.diamond.dto;



import java.util.Date;

import com.diamond.diamond.entity.CreditEntity;

public class CreditDto {
	
	private String transactionId;
	private String customerName;
	private String invoice;
    private Date creditDate;
	private int creditAmmount;
	
	public CreditDto() {
		// TODO Auto-generated constructor stub
	}

	public CreditDto(String transactionId, String customerName, String invoice, Date creditDate, int creditAmmount) {
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

	@Override
	public String toString() {
		return "CreditDto [transactionId=" + transactionId + ", customerName=" + customerName + ", invoice=" + invoice
				+ ", creditDate=" + creditDate + ", CreditAmmount=" + creditAmmount + "]";
	}
	
	
	public CreditDto EntityToDtoCredit(CreditEntity entity) {
		
		CreditDto creditDto= new CreditDto();
		creditDto.setTransactionId(entity.getTransactionId());
		creditDto.setCustomerName(entity.getCustomerName());
		creditDto.setInvoice(entity.getInvoice());
		creditDto.setCreditDate(entity.getCreditDate());
		creditDto.setCreditAmmount(entity.getCreditAmmount());
		return creditDto;
		
		
	}
	
	public CreditEntity DtoToEntityCredit(CreditDto dto) {
		CreditEntity creditEntity= new CreditEntity();
		creditEntity.setTransactionId(dto.getTransactionId());
		creditEntity.setCustomerName(dto.getCustomerName());
		creditEntity.setInvoice(dto.getInvoice());
	    creditEntity.setCreditDate(dto.getCreditDate());
	    creditEntity.setCreditAmmount(dto.getCreditAmmount());
	     return creditEntity;
	}

}
