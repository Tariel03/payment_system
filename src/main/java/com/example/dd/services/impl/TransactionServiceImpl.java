package com.example.dd.services.impl;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.entities.Transaction;
import com.example.dd.exceptions.NotFoundById;
import com.example.dd.repos.TransactionRepository;
import com.example.dd.services.repo.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository repository;
    @Override
    public void generate(TransactionRequest request) {
        Transaction transaction = Transaction.builder()
                .sum(request.getSum())
                .business(request.getBusiness())
                .expirationDate(request.getExpirationDate())
                .build();
        repository.save(transaction);

    }

    @Override
    public Transaction findRawById(Long id) {
        return repository.findById(id).orElseThrow(() ->
        new NotFoundById("Not found by id : " + id));
    }
}
