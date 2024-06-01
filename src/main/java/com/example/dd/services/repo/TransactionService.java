package com.example.dd.services.repo;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.dto.response.TransactionResponse;
import com.example.dd.entities.Transaction;

import java.util.List;

public interface TransactionService {

    TransactionResponse findById(Long id);

    List<TransactionResponse> findAll();

    Long generate(TransactionRequest request);

    void save(TransactionRequest request);

}
