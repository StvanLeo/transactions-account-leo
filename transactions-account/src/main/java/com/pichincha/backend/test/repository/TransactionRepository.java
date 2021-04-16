package com.pichincha.backend.test.repository;

import com.pichincha.backend.test.model.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Query("SELECT u FROM Transaction AS u WHERE u.account.id = :accountId")
	List<Transaction> findAllByAccountId(Long accountId);
}
