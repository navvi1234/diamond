package com.diamond.diamond.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diamond.diamond.dto.CreditDto;
import com.diamond.diamond.dto.CustomerDto;
import com.diamond.diamond.dto.CustomerUpdateDto;
import com.diamond.diamond.service.CreditService;
import com.diamond.diamond.service.CustomerServiceImpl;
import com.diamond.diamond.util.UtilRestResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	CreditService creditService;
	
	
	@GetMapping(value="/customers/get-list", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<List<CustomerDto>>> getAllCustomers() {
		List<CustomerDto> customersList=new ArrayList<>();
		Map<String, Object> errors=new HashMap<>();
		try {
			customersList=customerService.getAllCustomerDetails();
			if(customersList.size()>0) {
				 errors.put("errors", false);
				 UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString() , "successfully", customersList);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
			}else {
				errors.put("errors", true);
				 UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString() , "Data notexist", customersList);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
			}
		} catch(Exception e) {
			errors.put("errors", true);
			 UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString() , "failure", customersList);
			 response.setError(errors);
			 return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/customers/get-listByName/{customerName}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<List<CustomerDto>>> getAllCustomersByName(@PathVariable String customerName){
		List<CustomerDto> customers=new ArrayList<>();
		Map<String,Object> errors=new HashMap<>();
		try {
			customers=customerService.getAllByCusomerName(customerName);
			if(customers.size()>0) {
				errors.put("errors", false);
				UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString(), "successfully", customers);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
			}else {
				errors.put("errors", true);
				UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString(), "Customer Name notexist", customers);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);	
			}
		} catch(Exception e) {
			errors.put("errors", true);
			UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString(), "failure", customers);
			response.setError(errors);
			return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/customers/get-listByInvoice/{invoice}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<List<CustomerDto>>> getAllCustomersByInvoice(@PathVariable String invoice){
		List<CustomerDto> customers=new ArrayList<>();
		Map<String,Object> errors=new HashMap<>();
		try {
			customers=customerService.getAllByInvoice(invoice);
			if(customers.size()>0) {
				errors.put("errors", false);
				UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString(), "successfully", customers);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
			}else {
				errors.put("errors", true);
				UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString(), "invoice notexist", customers);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);	
				}
		} catch(Exception e) {
			errors.put("errors", true);
			UtilRestResponse<List<CustomerDto>> response=new UtilRestResponse<List<CustomerDto>>(HttpStatus.OK.toString(), "failure", customers);
			response.setError(errors);
			return new ResponseEntity<UtilRestResponse<List<CustomerDto>>>(response,HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/customers/add-customers",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<Map<String, String>>> addCustomers(@RequestBody CustomerDto customerDto){
		Map<String, String> result=new HashMap<>();
		Map<String, Object> errors=new HashMap<>();
		String res,msg="";
		 try {
			 res=customerService.addInvoice(customerDto);
			 if(res.contains("success")) {
				 result.put("Invoice",customerDto.getInvoice());
				 errors.put("errors", false);
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), "succesfully", result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
			 else {
				 result.put("Invoice",customerDto.getInvoice());
				 errors.put("errors", true);
				 if(res.contains("already")) {
					 msg=res;
				 }
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), msg, result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
		 } catch(Exception e) {
			 errors.put("errors", true);
				UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String, String>>(HttpStatus.OK.toString(), "failure", result);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<Map<String, String>>>(response,HttpStatus.OK);
		 }
	}
	
	
	@PutMapping(value="/customers/modify-customers",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<Map<String, String>>> modifyCustomers(@RequestBody CustomerUpdateDto customerUpdateDto){
		Map<String, String> result=new HashMap<>();
		Map<String, Object> errors=new HashMap<>();
		System.out.println(customerUpdateDto.getNewInvoice());
		String res,msg="";
		 try {
			 res=customerService.modifyInvoice(customerUpdateDto);
			 if(res.contains("success")) {
				 result.put("Invoice",customerUpdateDto.getInvoice());
				 errors.put("errors", false);
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), "succesfully", result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
			 else {
				 result.put("Invoice",customerUpdateDto.getInvoice());
				 errors.put("errors", true);
				 if(res.contains("invoice already exist")) {
					 msg="Invoice alredy exist";
				 }
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), msg, result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
		 } catch(Exception e) {
			 errors.put("errors", true);
				UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String, String>>(HttpStatus.OK.toString(), "failure", result);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<Map<String, String>>>(response,HttpStatus.OK);
		 }
	}
	
//	@PutMapping(value="/customers/modify-invoice",produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<UtilRestResponse<Map<String, String>>> modifyInvoice(@RequestParam String invoice, @RequestParam String newInvoice){
//		Map<String, String> result=new HashMap<>();
//		Map<String, Object> errors=new HashMap<>();
//		String res,msg="";
//		 try {
//			 res=customerService.modifyInvoice(invoice,newInvoice);
//			 if(res.contains("success")) {
//				 result.put("Invoice",invoice);
//				 errors.put("errors", false);
//				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), "succesfully", result);
//				 response.setError(errors);
//				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
//			 }
//			 else {
//				 result.put("Invoice",invoice);
//				 errors.put("errors", true);
//				 if(res.contains("failure")) {
//					 msg=res;
//				 }
//				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), msg, result);
//				 response.setError(errors);
//				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
//			 }
//		 } catch(Exception e) {
//			 errors.put("errors", true);
//				UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String, String>>(HttpStatus.OK.toString(), "failure", result);
//				response.setError(errors);
//				return new ResponseEntity<UtilRestResponse<Map<String, String>>>(response,HttpStatus.OK);
//		 }
//	}
	
	@DeleteMapping(value="/customers/delete-customers/{invoice}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<Map<String, String>>> deleteInvoice(@PathVariable String invoice){
		Map<String, String> result=new HashMap<>();
		Map<String, Object> errors=new HashMap<>();
		String res,msg="";
		 try {
			 res=customerService.deleteCustomer(invoice);
			 if(res.contains("success")) {
				 result.put("invoice",invoice);
				 errors.put("errors", false);
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), "deleted succesfully", result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
			 else {
				 result.put("invoice",invoice);
				 errors.put("errors", true);
				 if(res.contains("notexist")) {
					 msg=res;
				 }
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), msg, result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
		 } catch(Exception e) {
			    errors.put("errors", true);
				UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String, String>>(HttpStatus.OK.toString(), "deletion failure", result);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<Map<String, String>>>(response,HttpStatus.OK);
		 }
	}
	

	

}
