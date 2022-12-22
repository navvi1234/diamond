package com.diamond.diamond.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diamond.diamond.dto.CustomerDto;
import com.diamond.diamond.dto.CustomerUpdateDto;
import com.diamond.diamond.entity.CreditEntity;
import com.diamond.diamond.entity.CustomerEntity;
import com.diamond.diamond.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerDto> getAllCustomerDetails() throws Exception {
		List<CustomerDto> dtoList=new ArrayList<>();
		try {
			List<CustomerEntity> entityList=customerRepository.findAllBy();
			
			for (CustomerEntity customerEntity : entityList) {
				 CustomerDto customerDto=new CustomerDto();
				 customerDto=customerDto.EntityToDtoCustomer(customerEntity);
				 dtoList.add(customerDto);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return dtoList;
	}

	@Override
	public String addInvoice(CustomerDto customerDto)throws Exception {
		List<CustomerEntity> entityList=customerRepository.findAllByInvoice(customerDto.getInvoice());
		
		CustomerEntity customerEntityAdd= new CustomerEntity();
		
		if(entityList.size()>0) {
			return "error invoice already Exist";
		}
		customerEntityAdd=customerDto.DtoToEntityCustomer(customerDto);
		try {
			CustomerEntity entity=customerRepository.save(customerEntityAdd);
			return entity.getInvoice()+ "added successfully";
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	
	}

	@Override
	public List<CustomerDto> getAllByCusomerName(String customerName) throws Exception {
		List<CustomerDto> dtoList=new ArrayList<>();
		//System.out.println(customerName.trim.length());
        //String customerName1=customerName.trim();
        System.out.println(customerName);
		try {
			List<CustomerEntity> entityList=customerRepository.findAllByCustomerName(customerName);
			for (CustomerEntity customerEntity : entityList) {
				 CustomerDto customerDto=new CustomerDto();
				 customerDto=customerDto.EntityToDtoCustomer(customerEntity);
				 dtoList.add(customerDto);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return dtoList;
	}

	@Override
	public List<CustomerDto> getAllByInvoice(String invoice) throws Exception {
		List<CustomerDto> dtoList=new ArrayList<>();
		try {
			List<CustomerEntity> entityList=customerRepository.findAllByInvoice(invoice);
			for (CustomerEntity customerEntity : entityList) {
				 CustomerDto customerDto=new CustomerDto();
				 customerDto=customerDto.EntityToDtoCustomer(customerEntity);
				 dtoList.add(customerDto);
			}
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return dtoList;
	}

//	@Override
//	public String modifyCustomer(CustomerDto customerDto) throws Exception {
//		CustomerEntity customerEntityAdd= new CustomerEntity();
//		customerEntityAdd=customerDto.DtoToEntityCustomer(customerDto);
//		try {
//			CustomerEntity entity=customerRepository.save(customerEntityAdd);
//			return entity.getInvoice()+ "modified successfully";
////			int ms=customerRepository.updateCustomers(customerEntityAdd.getInvoice(), customerEntityAdd.getCustomerName(),
////					 customerEntityAdd.getAmmount(), customerEntityAdd.getLeftAmmount());
////			System.out.println(ms);
////			return "modified successfully";
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//			throw new Exception(e.getMessage());
//		}
//	}
	@Override
	public String modifyInvoice(CustomerUpdateDto customerUpdateDto) throws Exception {
		String msg="";
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerName(customerUpdateDto.getCustomerName());
		customerDto.setInvoice(customerUpdateDto.getInvoice());
		customerDto.setSelldate(customerUpdateDto.getSelldate());
		customerDto.setAmmount(customerUpdateDto.getAmmount());
		customerDto.setLeftAmmount(customerUpdateDto.getLeftAmmount());
		CustomerEntity customerEntity=customerDto.DtoToEntityCustomer(customerDto);
		List<CustomerEntity> entityList=customerRepository.findAllByInvoice(customerUpdateDto.getNewInvoice());
		if(entityList.size()>0 && !customerUpdateDto.getNewInvoice().equalsIgnoreCase(customerUpdateDto.getInvoice())) {
			return "invoice already exist";
		}
		try {
			int res=customerRepository.updateCustomers(customerEntity.getCustomerName(),customerEntity.getInvoice(),customerEntity.getSelldate(),
					customerEntity.getAmmount(),customerEntity.getLeftAmmount(),customerUpdateDto.getNewInvoice());
			if(res>0) {
				msg= "modified successfully";
			}else {
				msg="failure";
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
		return msg;
	}
	
	@Override
	public String deleteCustomer(String invoice) throws Exception {
		//System.out.println(id.length());
        List<CustomerEntity> entityList=customerRepository.findAllByInvoice(invoice);
		
		if(entityList.size()==0) {
			return "error id notexist";
		}
		try {
			customerRepository.deleteById(invoice);
			return "Invoice "+ invoice+ "is deleted successfully";
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
