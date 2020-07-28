package com.rabo.loan.management.vo;

import java.io.Serializable;
import java.sql.Date;


public class LoanDetailsRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2704107760645448746L;

	
	private int loainNumber;
	
	private String loanType;
	
	private double amount;
	
	private Date createDate;

	private int noOfMonths;

	private UserRequest user;

	public LoanDetailsRequest() {
	}

	/**
	 * @return the loainNumber
	 */
	public int getLoainNumber() {
		return loainNumber;
	}

	/**
	 * @param loainNumber the loainNumber to set
	 */
	public void setLoainNumber(int loainNumber) {
		this.loainNumber = loainNumber;
	}

	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}

	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param startDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the noOfMonths
	 */
	public int getNoOfMonths() {
		return noOfMonths;
	}

	/**
	 * @param noOfMonths the noOfMonths to set
	 */
	public void setNoOfMonths(int noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	/**
	 * @return the user
	 */
	public UserRequest getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserRequest user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loainNumber;
		result = prime * result + ((loanType == null) ? 0 : loanType.hashCode());
		result = prime * result + noOfMonths;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanDetailsRequest other = (LoanDetailsRequest) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (loainNumber != other.loainNumber)
			return false;
		if (loanType == null) {
			if (other.loanType != null)
				return false;
		} else if (!loanType.equals(other.loanType))
			return false;
		if (noOfMonths != other.noOfMonths)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loans [loainNumber=" + loainNumber + ", loanType=" + loanType + ", amount=" + amount + ", createDate="
				+ createDate + ", noOfMonths=" + noOfMonths + ", user=" + user + "]";
	}

}
