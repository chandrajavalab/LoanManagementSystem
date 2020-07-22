package com.rabo.loan.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabo.loan.management.repository.UserRepository;
import com.rabo.loan.management.service.LoanManagementService;
import com.rabo.loan.management.vo.User;

public class LoanManagementServiceImpl implements LoanManagementService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> serch(int userId) {
		// TODO Auto-generated method stub
		return null; //userRepository.findById(userId);
	}

	@Override
	public User userLogin(String userName, String password) {
		User user = userRepository.findByUsername(userName);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}
