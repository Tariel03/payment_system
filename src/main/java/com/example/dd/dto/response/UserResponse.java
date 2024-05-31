package com.example.dd.dto.response;

import jakarta.persistence.Column;

public class UserResponse {
    Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
}
