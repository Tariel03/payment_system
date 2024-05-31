package com.example.dd.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@Setter
@Builder
@Getter
public class CardRequest {
    @Size(max = 16, min = 16, message = "Длина номера должна составлять 16 цифр")
    String number;
    @NotBlank(message = "Name can't blank")
    @NotNull
    String nameOwner;
    LocalDate expiration;
    @Size(min =3, max = 3, message = "CCV must be 3")
    int cvc;
}
