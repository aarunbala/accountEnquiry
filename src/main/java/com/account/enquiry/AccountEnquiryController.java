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

/**
 * @author arun.balasubramanian
 *
 * Controller class that provides Account Enquiry functionality.
 */
@Validated
@RestController
public class AccountEnquiryController {

	private Logger log = LoggerFactory.getLogger(AccountEnquiryController.class);

	@Autowired
	IAccountEnquiryService service;

	
	/**
	 * Method gets all the accounts for the provided User; If no accounts are available for an User,
	 * then responds with an 204 status code. Also, responds with 400 for invalid arguments.
	 * 
	 * Using GetMapping instead of RequestMapping as its more readable and supports CORS by default.
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping(path = "/accountEnquiry/{userId}/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts(
			@PathVariable @NotBlank(message = "User Id cannot be blank") @Size(min = 3, max = 9, message = "User Id must be of size 3 to 9 characters") String userId) {
		
		log.info("Get All accounts for User : {} ", userId);
		List<Account> accounts = service.getAllAccounts(userId);
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);
		if (accounts == null || accounts.isEmpty()) {
			response = new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}
		log.debug("Exiting Function");
		return response;
	}

	/**
	 * Method gets the accounts details of the provided Account number and User Id.
	 * 
	 * @param userId
	 * @param accountNumber
	 * @return
	 */
	@GetMapping(path = "/accountEnquiry/{userId}/{accountNumber}/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccountByAccountNumber(
			@PathVariable @NotBlank @Size(min = 3, max = 9, message = "User Id must not be blank and must be of size 3 to 9 characters") String userId,
			@PathVariable Long accountNumber) {
		
		log.info("Get account for User : {} by Account Number: {} ", userId, accountNumber);
		Account account = service.getAccountByAccountNumber(userId, accountNumber);
		ResponseEntity<Account> response = null;
		if (account == null) {
			response = new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(account, HttpStatus.OK);
		}
		log.debug("Exiting Function");
		return response;
	}

	/**
	 * Method prevents any other resources from being accessed, throws PathNotFoundException which
	 * will get converted to HTTPStatus.BAD_REQUEST 400 status code.
	 * 
	 * @throws PathNotFoundException
	 */
	@GetMapping("/*")
	public void otherPaths() throws PathNotFoundException {
		throw new PathNotFoundException();
	}

}
