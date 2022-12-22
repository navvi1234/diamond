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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diamond.diamond.dto.CreditDto;
import com.diamond.diamond.service.CreditService;
import com.diamond.diamond.util.UtilRestResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CreditController {
	
	@Autowired
	CreditService creditService;
	
	@GetMapping(value="/credit/get-listByName/{customerName}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<List<CreditDto>>> getAllCreditByCustomerName(@PathVariable String customerName){
		List<CreditDto> credits=new ArrayList<>();
		Map<String,Object> errors=new HashMap<>();
		try {
			credits=creditService.getAllByCusomerName(customerName);
			if(credits.size()>0) {
				errors.put("errors", false);
				UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "successfully", credits);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
			}else {
				errors.put("errors", true);
				UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "Customer Name notexist", credits);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
			}
		} catch(Exception e) {
			errors.put("errors", true);
			UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "failure", credits);
			response.setError(errors);
			return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/credit/get-listByInvoice/{invoice}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<List<CreditDto>>> getAllCreditsByInvoice(@PathVariable String invoice){
		List<CreditDto> credits=new ArrayList<>();
		Map<String,Object> errors=new HashMap<>();
		try {
			credits=creditService.getAllByInvoice(invoice);
			if(credits.size()>0) {
					errors.put("errors", false);
					UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "successfully", credits);
					response.setError(errors);
					return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
			}else {
				errors.put("errors", true);
				UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "invoice notexist", credits);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
			}
		} catch(Exception e) {
			errors.put("errors", true);
			UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "failure", credits);
			response.setError(errors);
			return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/credit/get-listById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<List<CreditDto>>> getAllCreditsById(@PathVariable String id){
		List<CreditDto> credits=new ArrayList<>();
		Map<String,Object> errors=new HashMap<>();
		try {
			credits=creditService.getById(id);
			if(credits.size()>0) {
				errors.put("errors", false);
				UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "successfully", credits);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
			}else {
				errors.put("errors", true);
				UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "transaction id notexits", credits);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
			}
		} catch(Exception e) {
			errors.put("errors", true);
			UtilRestResponse<List<CreditDto>> response=new UtilRestResponse<List<CreditDto>>(HttpStatus.OK.toString(), "failure", credits);
			response.setError(errors);
			return new ResponseEntity<UtilRestResponse<List<CreditDto>>>(response,HttpStatus.OK);
		}
	}
	
	
	@PostMapping(value="/credit/add-credit/",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<Map<String, String>>> addCredit(@RequestBody CreditDto creditDto){
		Map<String, String> result=new HashMap<>();
		Map<String, Object> errors=new HashMap<>();
		String res,msg="";
		 try {
			 res=creditService.addCredit(creditDto);
			 if(res.contains("success")) {
				 result.put("invoice",creditDto.getInvoice());
				 errors.put("errors", false);
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), "added succesfully", result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
			 else {
				 result.put("invoice",creditDto.getInvoice());
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
				UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String, String>>(HttpStatus.OK.toString(), "Addition failure", result);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<Map<String, String>>>(response,HttpStatus.OK);
		 }
	}
	
	@DeleteMapping(value="/credit/delete-credit/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<Map<String, String>>> deleteCredit(@PathVariable String id){
		Map<String, String> result=new HashMap<>();
		Map<String, Object> errors=new HashMap<>();
		String res,msg="";
		 try {
			 res=creditService.deleteCredit(id);
			 if(res.contains("success")) {
				 result.put("id",id);
				 errors.put("errors", false);
				 UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String,String>>(HttpStatus.OK.toString(), "deleted succesfully", result);
				 response.setError(errors);
				 return new ResponseEntity<UtilRestResponse<Map<String,String>>>(response,HttpStatus.OK);
			 }
			 else {
				 result.put("id",id);
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
	@DeleteMapping(value="/credit/delete-ByInvoice/{invoice}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UtilRestResponse<Map<String, String>>> deleteAllCreditByInvoice(@PathVariable String invoice){
		Map<String, String> result=new HashMap<>();
		Map<String, Object> errors=new HashMap<>();
		String res,msg="";
		 try {
			 res=creditService.deleteAllByInvoice(invoice);
			 if(res.contains("deleted successfully")) {
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
			    System.out.println(e.getMessage());
			    errors.put("errors", true);
				UtilRestResponse<Map<String, String>> response=new UtilRestResponse<Map<String, String>>(HttpStatus.OK.toString(), "deletion failure", result);
				response.setError(errors);
				return new ResponseEntity<UtilRestResponse<Map<String, String>>>(response,HttpStatus.OK);
		 }
	}

}
