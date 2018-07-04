package com.comsoftacuity.dto;

import com.comsoftacuity.entity.AccountType;

public class Accountdto {


	private Integer id;
	private String code;
	private Boolean bookmarks;
	private String description;
	private AccountType accountType;
	

	public Accountdto() {
		
	}

	public Accountdto(Integer id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public Accountdto(Integer id, String code, String description, AccountType accountType) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.accountType = accountType;
	}

	public Accountdto(String code, String description) {
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
