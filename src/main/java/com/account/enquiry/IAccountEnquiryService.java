package com.account.enquiry;

import java.util.List;

import com.account.enquiry.model.Account;


/**
 * @author arun.balasubramanian
 * Service Interface
 */
public interface IAccountEnquiryService {
	List<Account> getAllAccounts(String userId);
	Account getAccountByAccountNumber(String userId, Long accountNumber);
}
