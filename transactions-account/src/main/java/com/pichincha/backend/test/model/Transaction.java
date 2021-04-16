package com.pichincha.backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id", referencedColumnName = "id", insertable = false, updatable = false)
	private Account account;
	
	@Column(name = "name_payer")
	private String namePayer;
	
	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getNamePayer() {
		return namePayer;
	}

	public void setNamePayer(String namePayer) {
		this.namePayer = namePayer;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
}
