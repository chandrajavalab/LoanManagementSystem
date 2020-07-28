package com.rabo.loan.management.exception;

public class LoanManagementException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9140749672964320369L;

	private String message;
	private String errorcode;

	public LoanManagementException(String message, String errorcode) {
		super();
		this.message = message;
		this.errorcode = errorcode;
	}

	public LoanManagementException(String message) {
		super();
		this.message = message;
	}

	public LoanManagementException() {
		super();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorcode
	 */
	public String getErrorcode() {
		return errorcode;
	}

	/**
	 * @param errorcode the errorcode to set
	 */
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

}
