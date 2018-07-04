package com.comsoftacuity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comsoftacuity.repository.AccountRepository;
import com.comsoftacuity.repository.AccountTypeRepository;
import com.comsoftacuity.repository.PaymentLogRepository;
import com.comsoftacuity.repository.SuggestionRepository;

@Service
@Transactional
public class ReportManagerService {

	/*
	 * private List<Accountdto> accounts = new ArrayList<>(Arrays.asList(new
	 * Accountdto(1, "Joseph", "personal account"), new Accountdto(2, "peter",
	 * "business account"), new Accountdto(3, "simon", "personal account")));
	 * 
	 * public List<Accountdto> getAllAccount() { return accounts; }
	 * 
	 * public Accountdto getCode(String code) { for (Accountdto accountdto :
	 * accounts) { if (accountdto.getCode().equals(code)) { return accountdto; } }
	 * return null; }
	 * 
	 * public void addAccount(Accountdto accountdto) { accounts.add(accountdto) ; }
	 * 
	 * public void updateAccount(Accountdto accountdto, String code) { for (int i =
	 * 0 ; i < accounts.size() ; i++ ) { Accountdto account = accounts.get(i) ; if
	 * (account.getCode().equals(code)) { accounts.set(i, accountdto) ; } } }
	 * 
	 * public void deleteAccount(String code) { int index = 0 ; for (Accountdto
	 * account : accounts) { if (account.getCode().equals(code)) {
	 * accounts.remove(index) ; } index++ ; } }
	 */

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	private PaymentLogRepository paymentLogRepository;

	@Autowired
	private SuggestionRepository suggestionRepository;

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public AccountTypeRepository getAccountTypeRepository() {
		return accountTypeRepository;
	}

	public PaymentLogRepository getPaymentLogRepository() {
		return paymentLogRepository;
	}

	public SuggestionRepository getSuggestionRepository() {
		return suggestionRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void setAccountTypeRepository(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}

	public void setPaymentLogRepository(PaymentLogRepository paymentLogRepository) {
		this.paymentLogRepository = paymentLogRepository;
	}

	public void setSuggestionRepository(SuggestionRepository suggestionRepository) {
		this.suggestionRepository = suggestionRepository;
	}

}
