package com.comsoftacuity.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PaymentLog")
public class PaymentLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;

	@Column(name="dateLog")
	private Date dateLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastModified", updatable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastModified;

	@Column(name="description")
	private String description;

	@Column(name="paymentType")
	private String paymentType;

	@ManyToOne
	private Account account;

	public PaymentLog(Integer id, Date dateLog, Date lastModified, String description, String paymentType,
			Account account) {
		super();
		this.id = id;
		this.dateLog = dateLog;
		this.lastModified = lastModified;
		this.description = description;
		this.paymentType = paymentType;
		this.account = account;
	}

	public PaymentLog() {
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
