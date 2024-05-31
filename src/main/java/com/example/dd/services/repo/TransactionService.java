package com.example.dd.services.repo;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.dto.response.TransactionResponse;
import com.example.dd.entities.Transaction;

public interface TransactionService {
    void generate(TransactionRequest request);
    Transaction findRawById(Long id);

}
