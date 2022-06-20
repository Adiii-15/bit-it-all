package com.isu.cs309.biditall.repository;

import com.isu.cs309.biditall.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}




