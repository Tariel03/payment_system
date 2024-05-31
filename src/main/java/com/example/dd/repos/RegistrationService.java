package com.example.dd.repos;

import com.example.dd.dto.request.UserRequest;
import com.example.dd.entities.AppUser;

import java.util.Optional;

public interface RegistrationService {

    Optional<AppUser> login(UserRequest userRequest);
    void registration(AppUser appUser);
    void save(AppUser appUser);
}
