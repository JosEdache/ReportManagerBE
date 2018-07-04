package com.comsoftacuity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , nullable=false)
	private Integer id;

	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;

	@Column(name="bookmarks" , columnDefinition="tinyint(1) default 0")
	private Boolean bookmarks;
	
	@ManyToOne
	private AccountType accountType;

	public Account() {
		super() ;
	}

	public Account(Integer id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public Account(Integer id, String code, String description, AccountType accountType) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.accountType = accountType;
	}
	
	public Account(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public Boolean getBookmarks() {
		return bookmarks;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setBookmarks(Boolean bookmarks) {
		this.bookmarks = bookmarks;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
