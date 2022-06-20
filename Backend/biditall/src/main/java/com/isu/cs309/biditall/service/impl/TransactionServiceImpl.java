package com.isu.cs309.biditall.service.impl;

import com.isu.cs309.biditall.exception.ResourceNotFoundException;
import com.isu.cs309.biditall.model.Transaction;
import com.isu.cs309.biditall.repository.TransactionRepository;
import com.isu.cs309.biditall.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository){

        this.transactionRepository=transactionRepository;

    }

    @Override
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);

    }

    @Override
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long sale_id){
        return transactionRepository.findById(sale_id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "Id", sale_id));

    }

    @Override
    public  void deleteTransaction(Transaction transaction){
        transactionRepository.delete(transaction);

    }

}
