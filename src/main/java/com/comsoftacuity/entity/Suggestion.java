package com.comsoftacuity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Suggestion")
public class Suggestion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="autocomplete")
	String autocomplete ;
	
	public Suggestion() {
		
	}

	public Suggestion(String autocomplete) {
		this.autocomplete = autocomplete;
	}

	public String getAutocomplete() {
		return autocomplete;
	}

	public void setAutocomplete(String autocomplete) {
		this.autocomplete = autocomplete;
	}
}
