package com.example.dd.dto.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@ToString
@Setter
public class UserRequest {
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
}
