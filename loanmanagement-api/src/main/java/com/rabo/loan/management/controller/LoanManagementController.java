package com.rabo.loan.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rabo.loan.management.service.LoanManagementService;
import com.rabo.loan.management.vo.User;

@RestController
public class LoanManagementController {
	
	@Autowired
	private LoanManagementService loanManagementService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(User requestVo) {
		loanManagementService.save(requestVo);
		return "Hello..!  " ;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin(@PathVariable String userName, @PathVariable String password ) {
		User userResponse = loanManagementService.userLogin(userName, password);
		return "Welcome " + userResponse.getFirstName();
	}
	
	@RequestMapping(value = "/serch", method = RequestMethod.GET)
	public String serchLoan(@PathVariable String userName, @PathVariable String password ) {
		User userResponse = loanManagementService.userLogin(userName, password);
		return "Welcome " + userResponse.getFirstName();
	}
	
	@RequestMapping(value = "/addloan", method = RequestMethod.POST)
	public String addLoan(@PathVariable String userName, @PathVariable String password ) {
		User userResponse = loanManagementService.userLogin(userName, password);
		return "Welcome " + userResponse.getFirstName();
	}
	
	@RequestMapping(value = "/updateloan", method = RequestMethod.POST)
	public String updateLoan(@PathVariable String userName, @PathVariable String password ) {
		User userResponse = loanManagementService.userLogin(userName, password);
		return "Welcome " + userResponse.getFirstName();
	}

}
