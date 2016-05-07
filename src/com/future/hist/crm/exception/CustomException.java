package com.future.hist.crm.exception;

/**
 * 
 * <p>Title: CustomException</p>
 * <p>Description: 系统自定义的异常类型，实际开发中可能要定义多种异常类型</p>
 * @version 1.0
 */
public class CustomException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//异常信息
	private String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
		
	}

	public CustomException() {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
