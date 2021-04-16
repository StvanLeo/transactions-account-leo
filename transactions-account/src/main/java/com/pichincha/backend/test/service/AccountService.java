package com.pichincha.backend.test.service;


import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.model.Transaction;
import com.pichincha.backend.test.repository.AccountRepository;
import com.pichincha.backend.test.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AccountService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	public AccountDto getAccount(Long id) {
		return accountRepository.findById(id)
			.map(account -> new AccountDto(account.getNumber(), account.getType(), account.getCreationDate()))
			.orElse(null);
	}

	/**
	 * Returns a list of all transactions for a account with passed id.
	 *
	 * @param accountId id of the account
	 * @return list of transactions sorted by creation date descending - most recent first
	 */
	public List<TransactionDto> getTransactionsForAccount(Long accountId) {
		List<TransactionDto> lisTransactionDtos = null;
		
		try {
			AccountDto accountUser = getAccount(accountId);
			if(accountUser != null) {
				lisTransactionDtos = (List<TransactionDto>) transactionRepository.findAllByAccountId(accountId)
						.stream()
						.filter(transaction -> transaction != null)
						.map(transaction -> 
						new TransactionDto(transaction.getId(), transaction.getComment(), transaction.getType(), transaction.getCreationDate()))
						.collect(Collectors.toList());
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		
		return lisTransactionDtos;
		
	}

	/**
	 * Creates a new transaction
	 *
	 * @param newTransactionDto data of new transaction
	 * @return id of the created transaction
	 * @throws IllegalArgumentException if there is no account for passed newTransactionDto.accountId
	 */
	public Long addTransaction(NewTransactionDto newTransactionDto) {
		Long transactionId = 0L;
		Account accountUser = null;
		Transaction transactionUser = new Transaction();
		
		try {
			if(newTransactionDto.getAccountId() != null) {
				Optional<Account> account = accountRepository.findById(newTransactionDto.getAccountId());
				if(account != null) {
					accountUser = account.get();
					
					if(accountUser != null) {
						transactionUser.setAccount(accountUser);
						transactionUser.setAmount(0L);
						transactionUser.setComment(newTransactionDto.getComment());
						transactionUser.setType(newTransactionDto.getType());
						transactionUser.setNamePayer("");
						transactionUser.setCreationDate(LocalDateTime.now());
						
						transactionUser = transactionRepository.saveAndFlush(transactionUser);
						transactionId = transactionUser.getId();
					}
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
		return transactionId;
	}

	public List<TransactionDto> getTransactionExtendDetail() {
		
		return null;
	}
}
