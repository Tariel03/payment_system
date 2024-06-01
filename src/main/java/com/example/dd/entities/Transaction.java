package com.example.dd.entities;

import com.example.dd.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Enumerated(value = EnumType.STRING)
    Status status;

    LocalDateTime createdAt;

    @PrePersist
    private void prePersist(){
        status = Status.SUCCESSFUL;
        createdAt = LocalDateTime.now();
    }
}
