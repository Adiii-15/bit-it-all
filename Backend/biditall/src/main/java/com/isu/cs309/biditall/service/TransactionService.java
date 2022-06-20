package com.isu.cs309.biditall.service;

import com.isu.cs309.biditall.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long sale_id);
    void deleteTransaction(Transaction transaction);
}
