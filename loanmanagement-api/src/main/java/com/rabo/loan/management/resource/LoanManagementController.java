package com.rabo.loan.management.resource;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabo.loan.management.service.LoanManagementService;
import com.rabo.loan.management.vo.LoanDetailsRequest;
import com.rabo.loan.management.vo.UserRequest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/loan-management/v1")
public class LoanManagementController {
	public static final Logger log = LoggerFactory.getLogger(LoanManagementController.class);
	
	@Autowired
	private LoanManagementService loanManagementService;
	
	@ApiOperation(value = "")
	@ApiImplicitParams({
	        @ApiImplicitParam()
	})
	@PostMapping(value = "/registration")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserRequest registration(@RequestBody UserRequest requestVo) throws Exception {
		final String methodname = "registration()";
		log.info("Enterrd into {}, requestbody {} ", methodname, requestVo);
		return loanManagementService.save(requestVo);
	}
	
	@PostMapping(value = "/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserRequest userLogin(@RequestBody UserRequest requestVo ) throws Exception {
		final String methodname = "userLogin()";
		log.info("Enterrd into {}, requestbody {} ", methodname, requestVo);
		return loanManagementService.userLogin(requestVo.getUserName(), requestVo.getPassword());
	}
	
	@PostMapping(value = "/addloan")
	@CrossOrigin(origins = "http://localhost:4200")
	public LoanDetailsRequest addLoan(@RequestBody LoanDetailsRequest loanDetails ) throws Exception {
		final String methodname = "addLoan()";
		log.info("Enterrd into {}, requestbody {} ", methodname, loanDetails);
		return loanManagementService.createLoan(loanDetails);
	}
	
	@GetMapping(value = "/serch/{userName}")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserRequest serchLoan(@PathVariable("userName") String userName) throws Exception {
		final String methodname = "serchLoan()";
		log.info("Enterrd into {}, userName {} ", methodname, userName);
		return loanManagementService.serchLoan(userName);
	}
	
	
	/*
	@RequestMapping(value = "/addloan", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public String addLoan(@PathVariable String userName, @PathVariable String password ) {
		User userResponse = loanManagementService.userLogin(userName, password);
		return "Welcome " + userResponse.getFirstName();
	}
	
	@RequestMapping(value = "/updateloan", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public String updateLoan(@PathVariable String userName, @PathVariable String password ) {
		User userResponse = loanManagementService.userLogin(userName, password);
		return "Welcome " + userResponse.getFirstName();
	}*/

}
