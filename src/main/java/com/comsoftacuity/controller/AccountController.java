package com.comsoftacuity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comsoftacuity.dto.AccountTypedto;
import com.comsoftacuity.dto.Accountdto;
import com.comsoftacuity.dto.PaymentLogdto;
import com.comsoftacuity.dto.Suggestiondto;
import com.comsoftacuity.entity.Account;
import com.comsoftacuity.entity.AccountType;
import com.comsoftacuity.entity.PaymentLog;
import com.comsoftacuity.mapper.Mapper;
import com.comsoftacuity.service.ReportManagerService;
import com.comsoftacuity.specifications.AccountTypeSpecification;
import com.comsoftacuity.specifications.PaymentLogSpecification;
import com.comsoftacuity.specifications.SuggestionSpecification;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class AccountController {

	@Autowired
	private ReportManagerService reportManagerService;

	/* Create Operation */
	@RequestMapping(method = RequestMethod.POST, value = "/accounts/{description}/create")
	public String createAccount(@RequestBody Accountdto accountdto, @PathVariable String description) {
		AccountType accountType = reportManagerService.getAccountTypeRepository().findByDescription(description);
		if (accountType != null) {
			reportManagerService.getAccountRepository().save(Mapper.mapToAccount(accountdto, accountType));
			return "Account creation success";
		}
		return "Account creation failed";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts/payment")
	public String makePayment(@RequestBody PaymentLogdto paymentLogdto) {
		if (paymentLogdto != null) {
			reportManagerService.getPaymentLogRepository().save(Mapper.mapToPaymentLog(paymentLogdto));
			return "Payment successfull";
		}
		return "Error";
	}

	/* Read Operation */
	@RequestMapping("/accounts/{id}")
	public Accountdto getAccount(@PathVariable Integer id) {
		return Mapper.mapToAccountdto(reportManagerService.getAccountRepository().findById(id).get());
	}
	
	@RequestMapping("/accounts/account-types")
	public List<AccountTypedto> getAllAccountType() {
		List<AccountType> accountType = new ArrayList<>();
		reportManagerService.getAccountTypeRepository().findAll().forEach(accountType::add);
		return Mapper.mapToAccountTypedtoList(accountType);
	}
	
	@RequestMapping("/accounts/account-types/{description}")
	public AccountType getAccountTypeByDescription(@PathVariable String description) {
		return reportManagerService.getAccountTypeRepository().findByDescription(description);
	}
	
	@RequestMapping("/accounts")
	public List<Accountdto> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		reportManagerService.getAccountRepository().findAll().forEach(accounts::add);
		return Mapper.mapToAccountdtoList(accounts);
	}

	
	@GetMapping("/accounts/payment-logs")
	public List<PaymentLogdto> getAllPaymentLog() {
		List<PaymentLog> paymentLogs = new ArrayList<>();
		reportManagerService.getPaymentLogRepository().findAll().forEach(paymentLogs::add);
		List<PaymentLogdto> paymentLogdtoList = Mapper.mapToPaymentLogList(paymentLogs);
		return paymentLogdtoList;
	}

	// Update Operation
	@RequestMapping(method = RequestMethod.PUT, value = "/accounts/update")
	public String updateAccount(@RequestBody Accountdto accountdto) {
		try {
			reportManagerService.getAccountRepository()
					.save(Mapper.mapToAccount(accountdto, accountdto.getAccountType()));
			return "Account updated successful";
		} catch (Exception e) {
			return "update failed";
		}
	}

	// Delete Operation
	@RequestMapping(method = RequestMethod.DELETE, value = "/accounts/delete/{id}")
	public String deleteAccount(@PathVariable String id) {
		try {
			reportManagerService.getAccountRepository().deleteById(Integer.parseInt(id));
			return "Account deleted successful";
		} catch (Exception e) {
			return "Account deletion failed";
		}
	}

	// search operation
	//@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/accounts/account-type/{searchTerm}")
	public List<AccountTypedto> search(@PathVariable String searchTerm) {
		//List<AccountType> accountTypes = new ArrayList<>();
		// accountTypes.add(reportManagerService.getAccountTypeRepository().findByDescriptionIgnoreCase(search));
		/*
		 * accountTypes = reportManagerService.getAccountTypeRepository().
		 * findByDescriptionContainsIgnoreCase(search); try { if
		 * (Integer.valueOf(search) instanceof Integer) { accountTypes =
		 * reportManagerService.getAccountTypeRepository()
		 * .findByIdContainsOrCodeContainsAllIgnoreCase(Integer.parseInt(search),
		 * Integer.parseInt(search)); } } catch (Exception exception) {
		 * 
		 * }
		 */
		
		/*accountTypes = reportManagerService.getAccountTypeRepository()
				.findAll(AccountTypeSpecification.searchTerm(searchTerm));
		return accountTypes;*/
		return Mapper.mapToAccountTypedtoList(reportManagerService.getAccountTypeRepository().findAll(AccountTypeSpecification.searchTerm(searchTerm)));
		
	}
	
	@GetMapping("/accounts/search/paymentlog")
	public List<PaymentLogdto> searchPaymentLog(@RequestParam(required=false) String queryTerm) {
		
		return Mapper.mapToPaymentLogList(reportManagerService.getPaymentLogRepository().findAll(PaymentLogSpecification.queryTerm(queryTerm)));
	}
	
	@GetMapping("/accounts/paymentlog/suggestion")
	public List<Suggestiondto> getSuggestion(@RequestParam("q") String queryTerm) {
		//reportManagerService.getSuggestionRepository().findAll().forEach(suggestions::add);
		return Mapper.mapToSuggestiondtoList(reportManagerService.getSuggestionRepository()
				.findAll(SuggestionSpecification.queryTerm(queryTerm)));
	}
	
}
