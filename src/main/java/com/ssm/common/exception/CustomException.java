package com.ssm.common.exception;
/***
 * 为什么使用自定义异常?
 * 更加精确定位具体异常信息
 */

public class CustomException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
