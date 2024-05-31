package com.example.dd.dto.response;

import com.example.dd.enums.CardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
public class CardResponse {
    @Size(max = 16, min = 16, message = "Длина номера должна составлять 16 цифр")
    String number;
    @NotBlank(message = "Name can't blank")
    @NotNull
    String nameOwner;
    LocalDate expiration;
    @Size(min =3, max = 3, message = "CCV must be 3")
    int cvc;
    CardType type;
}
