package com.example.dd.controllers;

import com.example.dd.dto.request.TransactionRequest;
import com.example.dd.entities.Transaction;
import com.example.dd.services.impl.AppUserImpl;
import com.example.dd.services.repo.BusinessService;
import com.example.dd.services.repo.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
@Tag(name = "Main")
public class MainController {

    final TransactionService transactionService;

    final BusinessService businessService;

    final AppUserImpl appUserService;

    private final List<Long> longList = new ArrayList<>();

    @PostMapping("/{sum}")
    public ResponseEntity<?> hello(@PathVariable("sum") Long sum) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long id = transactionService.generate(TransactionRequest.builder()
                .sum(sum)
                .business(businessService.findByAppUser(appUserService.findByUsername(userDetails.getUsername()).get()))
                .build());
        longList.add(id);
        System.out.println(longList);
        return ResponseEntity.ok("Transaction pending !");
    }

    @PostMapping("/add")
    public ResponseEntity<?> hello(TransactionRequest transactionRequest){
        Collections.sort(longList);
        transactionRequest.setId(longList.get(0));
        transactionService.save(transactionRequest);
        longList.remove(0);
        return ResponseEntity.ok("Transaction saved");
    }

}
