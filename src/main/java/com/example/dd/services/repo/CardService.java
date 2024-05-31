package com.example.dd.services.repo;

import com.example.dd.dto.request.CardRequest;
import com.example.dd.dto.response.CardResponse;

import java.util.List;

public interface CardService {
    void save(CardRequest cardRequest);
    CardResponse findById(Long id);
    CardResponse findByNumber(String number);
    List<CardResponse>findAll();

}
