package com.pichincha.backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "account", targetEntity = Transaction.class, 
			fetch = FetchType.LAZY)
	private List<Transaction> transactionList;

	@Column(name = "number")
	private String number;

	@Column(name = "type", length = 70)
	private String type;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String title) {
		this.number = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String content) {
		this.type = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

}
