package com.account.enquiry;

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
	
	public List<Account> getAllAccounts(String userId){
		log.debug("Getting all accounts for User", userId);
		return repository.findAllByUserId(userId);
	}
	
	public Account getAccountByAccountNumber(String userId, Long accountNumber) {
		log.debug("Getting account by Account number {} and {}", userId, accountNumber);
		return repository.findByUserIdAndAccountNumber(userId, accountNumber);
	}
}
