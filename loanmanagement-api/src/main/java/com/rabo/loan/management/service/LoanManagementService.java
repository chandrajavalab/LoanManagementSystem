package com.rabo.loan.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rabo.loan.management.vo.User;

@Service
public interface LoanManagementService {
	public User save(User user);

	public List<User> serch(int userId);

	public User userLogin(String userName, String password);
}
