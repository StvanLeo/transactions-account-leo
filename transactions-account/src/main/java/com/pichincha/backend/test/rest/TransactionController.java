package com.pichincha.backend.test.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.service.AccountService;

@Controller
@RestController
@RequestMapping(value = "/accounts/{id}/transactions", 
				produces = "application/json", 
				method = {RequestMethod.GET, RequestMethod.POST})
public class TransactionController {
	
	@Autowired
	private final AccountService aService;
	
	public TransactionController(AccountService accountService) {
		this.aService = accountService;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<TransactionDto> getTransactionsForAccount(@PathVariable Long id) {
		return aService.getTransactionsForAccount(id);
	}
	
	@PostMapping
	public Long addTransaction(@RequestBody NewTransactionDto transaction) {
		return aService.addTransaction(transaction);
	}
	
	@GetMapping(value = "extenddetail")
	public List<TransactionDto> getTransactionExtendDetail(HttpServletRequest request) {
		String extendDetail = request.getRequestURI();
		return aService.getTransactionExtendDetail();
	}
}
