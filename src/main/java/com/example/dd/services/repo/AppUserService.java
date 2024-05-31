package com.example.dd.services.repo;

import com.example.dd.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    AppUser findById(Long id);
    void save(AppUser user);
    List<AppUser> findAll();
    Optional<AppUser> findByUsername(String username);
}
