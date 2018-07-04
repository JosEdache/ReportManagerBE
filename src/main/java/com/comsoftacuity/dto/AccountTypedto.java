package com.comsoftacuity.dto;

public class AccountTypedto {

	private Integer id;
	private Integer code;
	private String description;

	public AccountTypedto() {
		super() ;
	}

	public AccountTypedto(Integer id, Integer code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}

	public AccountTypedto(Integer code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
