package com.diamond.diamond.service;

import java.util.List;

import com.diamond.diamond.dto.CreditDto;



public interface CreditService {
	
    String addCredit(CreditDto creditDto)throws Exception;
    
    String deleteCredit(String id)throws Exception;
	
	List<CreditDto> getAllByCusomerName(String customerName) throws Exception;
	
	List<CreditDto> getAllByInvoice(String invoice) throws Exception;
	
	List<CreditDto> getById(String id) throws Exception;
	
	String deleteAllByInvoice(String invoice) throws Exception;
}
