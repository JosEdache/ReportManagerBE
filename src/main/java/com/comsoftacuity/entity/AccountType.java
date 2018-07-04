package com.comsoftacuity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AccountType implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , nullable=false)
	private Integer id;

	@Column(name="code")
	private Integer code;

	@Column(name="description")
	private String description;

	public AccountType() {
		super();
	}

	public AccountType(Integer id, Integer code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public AccountType(Integer code, String description) {
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
