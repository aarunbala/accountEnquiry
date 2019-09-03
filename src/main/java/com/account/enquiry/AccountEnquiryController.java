package com.account.enquiry;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.account.enquiry.model.Account;

@Validated
@RestController
public class AccountEnquiryController {

	private Logger log = LoggerFactory.getLogger(AccountEnquiryController.class);

	@Autowired
	IAccountEnquiryService service;

	// Using GetMapping instead of RequestMapping as its more readable and
	// supports CORS by default.
	@GetMapping(path = "/accountEnquiry/{userId}/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts(
			@PathVariable @NotBlank(message = "User Id cannot be blank") @Size(min = 3, max = 9, message = "User Id must be of size 3 to 9 characters") String userId) {
		
		log.info("Get All accounts for User : {} ", userId);
		List<Account> accounts = service.getAllAccounts(userId);
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);
		if (accounts == null || accounts.isEmpty()) {
			response = new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@GetMapping(path = "/accountEnquiry/{userId}/{accountNumber}/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccountByAccountNumber(
			@PathVariable @NotBlank @Size(min = 3, max = 9, message = "User Id must not be blank and must be of size 3 to 9 characters") String userId,
			@PathVariable Long accountNumber) {
		
		log.info("Get account for User : {} by Account Number: {} ", userId, accountNumber);
		Account account = service.getAccountByAccountNumber(userId, accountNumber);
		ResponseEntity<Account> response = new ResponseEntity<>(account, HttpStatus.OK);
		if (account == null) {
			response = new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@GetMapping("/*")
	public void otherPaths() throws PathNotFoundException {
		throw new PathNotFoundException();
	}

}
