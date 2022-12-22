package com.diamond.diamond.util;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown= true,value={"null"})
public class UtilRestResponse<T> {
	
	private String statusCode;
	private String msg;
	private T entity;
	private Map<String,Object> error;
	
	public UtilRestResponse(String statusCode, String msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}

	public UtilRestResponse(String statusCode, String msg, T entity) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.entity = entity;
	}

	public UtilRestResponse(String statusCode, T entity) {
		super();
		this.statusCode = statusCode;
		this.entity = entity;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Map<String, Object> getError() {
		return error;
	}

	public void setError(Map<String, Object> error) {
		this.error = error;
	}
	
	

}
