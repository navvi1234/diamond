package com.diamond.diamond.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diamond.diamond.dto.CreditDto;
import com.diamond.diamond.entity.CreditEntity;
import com.diamond.diamond.repository.CreditRepository;

@Service
@Transactional
public class CredtiServiceImpl implements CreditService {
	
	@Autowired
	CreditRepository creditRepository;

	@Override
	public String addCredit(CreditDto creditDto)throws Exception {
		List<CreditEntity> entityList=creditRepository.findAllById(creditDto.getTransactionId());
		
		CreditEntity creditEntityAdd= new CreditEntity();
		
		if(entityList.size()>0) {
			return "error invoice already Exist";
		}
		creditEntityAdd=creditDto.DtoToEntityCredit(creditDto);
		System.out.println(creditDto.getCreditDate());
		try {
			CreditEntity entity=creditRepository.save(creditEntityAdd);
			return entity.getTransactionId()+ "is added successfully for "+entity.getInvoice();
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<CreditDto> getAllByCusomerName(String customerName) throws Exception {
		List<CreditDto> dtoList=new ArrayList<>();
        //System.out.println(customerName);
		try {
			List<CreditEntity> entityList=creditRepository.findAllByCustomerName(customerName);
			for (CreditEntity creditEntity : entityList) {
				 CreditDto creditDto=new CreditDto();
				 creditDto=creditDto.EntityToDtoCredit(creditEntity);
				 dtoList.add(creditDto);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return dtoList;
	}

	@Override
	public List<CreditDto> getAllByInvoice(String invoice) throws Exception {
		List<CreditDto> dtoList=new ArrayList<>();
        //System.out.println(customerName);
		try {
			List<CreditEntity> entityList=creditRepository.findAllByInvoice(invoice);
			for (CreditEntity creditEntity : entityList) {
				 CreditDto creditDto=new CreditDto();
				 creditDto=creditDto.EntityToDtoCredit(creditEntity);
				 dtoList.add(creditDto);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return dtoList;
	}

	@Override
	public List<CreditDto> getById(String id) throws Exception {
		List<CreditDto> dtoList=new ArrayList<>();
		try {
			List<CreditEntity> entityList=creditRepository.findAllById(id);
			for (CreditEntity creditEntity : entityList) {
				 CreditDto creditDto=new CreditDto();
				 creditDto=creditDto.EntityToDtoCredit(creditEntity);
				 dtoList.add(creditDto);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return dtoList;
	}

	@Override
	public String deleteCredit(String id) throws Exception {
		System.out.println(id.length());
        List<CreditEntity> entityList=creditRepository.findAllById(id);
		
		if(entityList.size()==0) {
			return "error id notexist";
		}
		try {
			creditRepository.deleteById(id);
			return "Transaction id "+ id+ "is deleted successfully";
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String deleteAllByInvoice(String invoice) throws Exception {
		String msg="";
		try {
			  System.out.println(invoice);
			  creditRepository.deleteAllByInvoice(invoice);
			  msg="deleted successfully";
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return msg;
	}

//	@Override
//	public String deleteAllByInvoice(String invoice) throws Exception {
//		String msg="";
//		try {
//			  System.out.println(invoice);
//			  creditRepository.deleteAllByInvoice(invoice);
//			  msg="deleted successfully";
//			
//		}catch(Exception e){
//			throw new Exception(e.getMessage());
//		}
//		return msg;
//		
//	}

}
