package com.example.dd.controllers;


import com.example.dd.dto.response.TransactionResponse;
import com.example.dd.services.repo.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
@Tag(name = "Transaction")
public class TransactionController {

    final TransactionService transactionService;

    @GetMapping()
    public List<TransactionResponse> getAllList(){
        return transactionService.findAll();
    }

    @GetMapping("/{transaction_id}")
    public TransactionResponse getById(@PathVariable("transaction_id") Long id){
        return transactionService.findById(id);
    }



}
