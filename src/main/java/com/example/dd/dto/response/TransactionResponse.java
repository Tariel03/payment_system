package com.example.dd.dto.response;

import com.example.dd.entities.Business;
import com.example.dd.enums.Status;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionResponse {

    String numberSender;
    LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name = "business")
    Business business;
    Long sum;
    Status status;
    LocalDateTime createdAt;
}
