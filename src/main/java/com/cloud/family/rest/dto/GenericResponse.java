
package com.cloud.family.rest.dto;


public class GenericResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
    
    
    
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "GenericResponse [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}
	
	
    
    
}