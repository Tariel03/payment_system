package com.example.dd.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String numberSender;
    LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name = "business")
    Business business;
    Long sum;
}
