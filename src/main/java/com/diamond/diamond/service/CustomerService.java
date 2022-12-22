package com.diamond.diamond.service;

import java.util.List;

import com.diamond.diamond.dto.CustomerDto;
import com.diamond.diamond.dto.CustomerUpdateDto;


public interface CustomerService {
	
	List<CustomerDto> getAllCustomerDetails() throws Exception;
	
	String addInvoice(CustomerDto customerDto)throws Exception;
	
	List<CustomerDto> getAllByCusomerName(String customerName) throws Exception;
	
	List<CustomerDto> getAllByInvoice(String invoice) throws Exception;
	
	String modifyInvoice(CustomerUpdateDto customerUpdateDto)throws Exception;

	String deleteCustomer(String invoice) throws Exception;

	//String modifyCustomer(CustomerDto customerDto) throws Exception;
	
	
	
	
 
}
