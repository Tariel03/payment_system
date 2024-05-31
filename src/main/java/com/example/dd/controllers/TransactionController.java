package com.example.dd.controllers;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.entities.Business;
import com.example.dd.entities.Transaction;
import com.example.dd.services.impl.BusinessServiceImpl;
import com.example.dd.services.impl.TransactionServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    TransactionServiceImpl transactionService;
    BusinessServiceImpl businessService;
    @GetMapping()
    public List<Transaction> findTransactions(@RequestParam Long businessId){
        return transactionService.findByBusiness(businessService.findRawById(businessId));
    }
}
