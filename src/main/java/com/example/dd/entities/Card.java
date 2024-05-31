package com.example.dd.entities;

import com.example.dd.enums.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Size(max = 16, min = 16, message = "Длина номера должна составлять 16 цифр")
    String number;
    @NotBlank(message = "Name can't blank")
    @NotNull
    String nameOwner;
    LocalDate expiration;
    @Size(min =3, max = 3, message = "CCV must be 3")
    int cvc;
    @Enumerated(EnumType.STRING)
    CardType cardType;




}

