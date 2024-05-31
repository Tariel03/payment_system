package com.example.dd.controllers;

import com.example.dd.dto.request.CardRequest;
import com.example.dd.dto.response.CardResponse;
import com.example.dd.services.impl.CardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/card")
public class CardController {
    CardServiceImpl cardService;
    @PostMapping("/add/{businessId}")
    public void add(@RequestBody CardRequest request, @PathVariable Long businessId){
        cardService.save(request, businessId);
    }
    @GetMapping("/{id}")
    public CardResponse findById(@PathVariable Long id){
        return cardService.findById(id);
    }



}
