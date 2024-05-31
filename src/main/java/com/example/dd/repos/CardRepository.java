package com.example.dd.repos;

import com.example.dd.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card>findByNumber(String number);

}
