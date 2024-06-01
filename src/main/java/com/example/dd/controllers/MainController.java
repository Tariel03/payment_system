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

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
@Tag(name = "Main")
public class MainController {

    final TransactionService transactionService;

    final BusinessService businessService;

    final AppUserImpl appUserService;

    @PostMapping("/{sum}")
    public ResponseEntity<?> hello(@PathVariable("sum") Long sum){
        transactionService.generate(TransactionRequest.builder().sum(sum).build());
        return ResponseEntity.ok("Transaction saved !");
    }

//    @PostMapping()
//    public {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        transactionRequest.setBusiness(businessService.findByAppUser(appUserService.findByUsername(userDetails.getUsername()).get()));
//        transactionRequest.setSum(sum);
//        transactionService.generate(transactionRequest);
//    }

}
