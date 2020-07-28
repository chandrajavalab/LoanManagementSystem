package com.rabo.loan.management.enity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOAN_DETAILS")
public class LoanDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2704107760645448746L;

	@Id
	@Column(name = "LOAN_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int loanNumber;
	@Column(name = "LOAN_TYPE")
	private String loanType;
	@Column(name = "AMOUNT")
	private double amount;
	@Column(name = "CREATE_DT")
	private Date createDate;
	@Column(name = "NO_OF_MONTHS")
	private int noOfMonths;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User user;

	public LoanDetails() {
	}

	/**
	 * @return the loainNumber
	 */
	public int getLoanNumber() {
		return loanNumber;
	}

	/**
	 * @param loanNumber the loanNumber to set
	 */
	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
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
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loanNumber;
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
		LoanDetails other = (LoanDetails) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (loanNumber != other.loanNumber)
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
		return "Loans [loanNumber=" + loanNumber + ", loanType=" + loanType + ", amount=" + amount + ", createDate="
				+ createDate + ", noOfMonths=" + noOfMonths + ", user=" + user + "]";
	}

}
