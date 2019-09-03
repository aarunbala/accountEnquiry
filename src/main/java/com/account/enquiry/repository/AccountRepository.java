package com.account.enquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.account.enquiry.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findAllByUserId(String userId); 
	Account findByUserIdAndAccountNumber(String userId, long accountNumber);
}
