package com.rabo.loan.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rabo.loan.management.resource.LoanManagementController;
import com.rabo.loan.management.vo.ResponseOutput;

@ControllerAdvice(assignableTypes = LoanManagementController.class)
public class LoanManagementExceptionHandler {

	@ExceptionHandler(LoanManagementException.class)
	@ResponseBody
	public ResponseEntity<Object> throwsLoanManagementException(LoanManagementException ex) {
		ResponseOutput responseOutput = new ResponseOutput();
		responseOutput.setErrorCode(ex.getErrorcode());
		responseOutput.setMessage(ex.getMessage());
		return new ResponseEntity<>(responseOutput, HttpStatus.BAD_REQUEST);
	}
}
