package com.example.dd.services.impl;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.dto.response.TransactionResponse;
import com.example.dd.entities.Transaction;
import com.example.dd.exceptions.NotFoundById;
import com.example.dd.mappers.TransactionMapper;
import com.example.dd.repos.TransactionRepository;
import com.example.dd.services.repo.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository repository;

    @Override
    public TransactionResponse findById(Long id) {
        return TransactionMapper.mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundById("Transaction with ID: %s not found !".formatted(id))));
    }

    @Override
    public List<TransactionResponse> findAll() {
        return TransactionMapper.mapper.listToResponse(repository.findAll());
    }

    @Override
    public Long generate(TransactionRequest request) {
        return repository.save(TransactionMapper.mapper.toEntity(request)).getId();
    }

    @Override
    public void save(TransactionRequest request) {
        Transaction transaction = repository.findById(request.getId()).orElse(null);
        transaction.setNumberSender(request.getNumberSender());
        transaction.setExpirationDate(request.getExpirationDate());
        repository.save(transaction);
    }


}
