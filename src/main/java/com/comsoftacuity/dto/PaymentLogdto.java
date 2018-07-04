package com.comsoftacuity.dto;



import java.util.Date;

import com.comsoftacuity.entity.Account;

public class PaymentLogdto {


	private Integer id;
	private Date dateLog;
	private Date lastModified;
	private String description;
	private String paymentType;

	private Account account;

	public PaymentLogdto(Integer id, Date dateLog, Date lastModified, String description, String paymentType,
			Account account) {
		super();
		this.id = id;
		this.dateLog = dateLog;
		this.lastModified = lastModified;
		this.description = description;
		this.paymentType = paymentType;
		this.account = account;
	}

	public PaymentLogdto() {
		super();
	}

	public Account getAccount() {
		return account;
	}

	public Date getDateLog() {
		return dateLog;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setDateLog(Date dateLog) {
		this.dateLog = dateLog;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
