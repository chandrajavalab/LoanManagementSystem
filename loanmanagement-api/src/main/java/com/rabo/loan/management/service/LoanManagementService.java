package com.rabo.loan.management.service;

import org.springframework.stereotype.Service;

import com.rabo.loan.management.vo.LoanDetailsRequest;
import com.rabo.loan.management.vo.UserRequest;

@Service
public interface LoanManagementService {
	public UserRequest save(UserRequest user) throws Exception;

	public UserRequest userLogin(String userName, String password) throws Exception;

	public LoanDetailsRequest createLoan(LoanDetailsRequest loanDetails) throws Exception;

	public UserRequest serchLoan(String userName) throws Exception;
}
