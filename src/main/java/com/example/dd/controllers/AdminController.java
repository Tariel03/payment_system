package com.example.dd.controllers;

import com.example.dd.entities.AppUser;
import com.example.dd.entities.Transaction;
import com.example.dd.security.AppUserDetailsService;
import com.example.dd.services.impl.AppUserImpl;
import com.example.dd.services.impl.BusinessServiceImpl;
import com.example.dd.services.impl.TransactionServiceImpl;
import com.example.dd.services.repo.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    AppUserImpl appUserService;
    BusinessServiceImpl businessService;
    TransactionServiceImpl transactionService;
    @GetMapping("/accounts")
    public List<AppUser> accounts(){
        return appUserService.findAll();
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions(){
        return transactionService.findAll();
    }







}
