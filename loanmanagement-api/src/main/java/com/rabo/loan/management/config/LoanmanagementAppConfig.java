package com.rabo.loan.management.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rabo.loan.management.service.LoanManagementService;
import com.rabo.loan.management.service.impl.LoanManagementServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.rabo.loan.management" })
public class LoanmanagementAppConfig {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mysql");
		dataSource.setUsername("root");
		dataSource.setPassword("pass@word1");
        return dataSource;
	}
	
	@Bean
	public LoanManagementService loanManagementService() {
		return new LoanManagementServiceImpl();
	}
}
