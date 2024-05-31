package com.example.dd.dto.request;

import com.example.dd.entities.Business;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionRequest {
    String numberSender;
    LocalDate expirationDate;
    @JsonIgnore
    Business business;
    @JsonIgnore
    Long sum;
}
