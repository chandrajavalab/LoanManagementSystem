package com.rabo.loan.management.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabo.loan.management.enity.LoanDetails;
import com.rabo.loan.management.enity.User;
import com.rabo.loan.management.exception.LoanManagementException;
import com.rabo.loan.management.repository.LoanDetailsRepository;
import com.rabo.loan.management.repository.UserRepository;
import com.rabo.loan.management.service.LoanManagementService;
import com.rabo.loan.management.vo.LoanDetailsRequest;
import com.rabo.loan.management.vo.UserRequest;

public class LoanManagementServiceImpl implements LoanManagementService{
	public static final Logger log = LoggerFactory.getLogger(LoanManagementServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoanDetailsRepository loanDetailsRepository;
	
	@Override
	public UserRequest save(UserRequest user) throws Exception {
		final String methodName = "save()";
		log.info("{} invoking the db to save the user", methodName);
		
		User userentity = getUserEntity(user);
		User userResponse = userRepository.save(userentity);
		return getUserResponse(userResponse);
		
	}


	/**
	 * @param userResponse
	 * @return
	 * @throws Exception
	 */
	private UserRequest getUserResponse(User userResponse) throws Exception {
		final String methodName = "getUserResponse()";
		log.info("{} get userRequest response object", methodName);
		UserRequest user = new UserRequest();
		BeanUtils.copyProperties(user, userResponse);
		return user;
	}


	
	/**
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private User getUserEntity(UserRequest user) throws Exception {
		final String methodName = "getUserEntity()";
		log.info("{} get user entity object", methodName);
		User userentity = new User();
		BeanUtils.copyProperties(userentity, user);
		return userentity;
	}


	/**
	 * @throws Exception 
	 *
	 */
	@Override
	public UserRequest userLogin(String userName, String password) throws Exception {
		User user = userRepository.findByUserNameAndPassword(userName, password);
		if(user != null) {
			return getUserResponse(user);
		}
		throw new LoanManagementException("Invalid username password", "201");
	}

	/**
	 *
	 */
	@Override
	public LoanDetailsRequest createLoan(LoanDetailsRequest loanDetails) throws Exception {
		final String methodName = "createLoan()";
		log.info("{} invoking the db to save the loan details", methodName);
		
		LoanDetails loanDetailsEntity = getLoanDetailesEntity(loanDetails);
		LoanDetails loanResponse = loanDetailsRepository.save(loanDetailsEntity);
		return getLaonDetailesResponse(loanResponse);
	}

	/**
	 * @param loanResponse
	 * @return
	 * @throws Exception
	 */
	private LoanDetailsRequest getLaonDetailesResponse(LoanDetails loanResponse) throws Exception {
		final String methodName = "getLaonDetailesResponse()";
		log.info("{} get LoanDetailes response object", methodName);
		LoanDetailsRequest loanDetailsResponse = new LoanDetailsRequest();
		BeanUtils.copyProperties(loanDetailsResponse, loanResponse);
		return loanDetailsResponse;
	}


	/**
	 * @param loanDetails
	 * @return
	 * @throws Exception
	 */
	private LoanDetails getLoanDetailesEntity(LoanDetailsRequest loanDetails) throws Exception {
		final String methodName = "getLoanDetailesEntity()";
		log.info("{} get LoanDetailes entity object", methodName);
		LoanDetails loanDetailsEntity = new LoanDetails();
		BeanUtils.copyProperties(loanDetailsEntity, loanDetails);
		return loanDetailsEntity;
	}


	@Override
	public UserRequest serchLoan(String userName) throws Exception {
		final String methodName = "serchLoan()";
		log.info("{} get user response from DB", methodName);
		User userEntity = userRepository.findByUserName(userName);
		return getUserResponse(userEntity);
	}

}
