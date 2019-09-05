package com.account.enquiry;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.enquiry.model.Account;
import com.account.enquiry.repository.AccountRepository;

/**
 * @author arun.balasubramanian
 * Default Service implementation for Account Service interface.
 * 
 */
@Service
public class AccountEnquiryService implements IAccountEnquiryService {
	
	private Logger log = LoggerFactory.getLogger(AccountEnquiryService.class);
	
	@Autowired
	private AccountRepository repository;
	
	/**
	 * Method fetches all the accounts for the User using JPA repositories.
	 * Paging has not yet been implemented. 
	 * 
	 * @param userId
	 */
	public List<Account> getAllAccounts(String userId){
		log.debug("Start of Function: Getting all accounts for User", userId);
		List<Account> accounts = repository.findAllByUserId(userId);
		log.debug("Exiting function");
		return accounts != null ? accounts : new ArrayList<Account>();
	}
	
	/**
	 * Method retrieves the account details for provided accountNumber & associated user.
	 * If the account is not associated with the user then provides an empty response.
	 *  
	 * @param userId
	 * @param accountNumber
	 */
	public Account getAccountByAccountNumber(String userId, Long accountNumber) {
		log.debug("Start of Function: Getting account by Account number {} and {}", userId, accountNumber);
		Account account = repository.findByUserIdAndAccountNumber(userId, accountNumber); 
		log.debug("Exiting function");
		return account;
	}
}
