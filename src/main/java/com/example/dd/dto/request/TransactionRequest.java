package com.example.dd.dto.request;

import com.example.dd.entities.Business;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

    String numberSender;

    LocalDate expirationDate;

    @JsonIgnore
    Business business;

    @JsonIgnore
    Long sum;

}
