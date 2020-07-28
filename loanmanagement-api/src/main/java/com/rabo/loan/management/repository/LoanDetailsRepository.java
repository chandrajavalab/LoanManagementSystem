package com.rabo.loan.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabo.loan.management.enity.LoanDetails;

public interface LoanDetailsRepository extends JpaRepository<LoanDetails, Integer>{

}
