package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AccountDto {

	public AccountDto() {
		
	}
	
	public AccountDto(String number, String type, LocalDateTime creationDate) {
		this.setNumber(number);
		this.setType(type);
		this.setCreationDate(creationDate);
	}

	private String number;

	private String type;

	private LocalDateTime creationDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
