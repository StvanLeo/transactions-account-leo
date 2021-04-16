package com.pichincha.backend.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewTransactionDto {

	private Long accountId;

	private String type;

	private String comment;
	
	public NewTransactionDto() {
		
	}
	
	public NewTransactionDto(String type, String comment) {
		this.setType(type);
		this.setComment(comment);
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
