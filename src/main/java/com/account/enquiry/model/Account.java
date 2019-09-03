package com.account.enquiry.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ACCOUNT_ENQUIRY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {

	@Id
	private long accountNumber;
	private String accountName;
	private BigDecimal balance;
	private Currency currency;
	private Date balanceAsOnDate;
	private String userId;
	
	@Enumerated(EnumType.STRING)
	private AccountType type;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNunber) {
		this.accountNumber = accountNunber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getBalanceAsOnDate() {
		return balanceAsOnDate;
	}

	public void setBalanceAsOnDate(Date balanceAsOnDate) {
		this.balanceAsOnDate = balanceAsOnDate;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", currency=" + currency + ", balanceAsOnDate=" + balanceAsOnDate + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((balanceAsOnDate == null) ? 0 : balanceAsOnDate.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Account other = (Account) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (balanceAsOnDate == null) {
			if (other.balanceAsOnDate != null)
				return false;
		} else if (!balanceAsOnDate.equals(other.balanceAsOnDate))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (type != other.type)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
