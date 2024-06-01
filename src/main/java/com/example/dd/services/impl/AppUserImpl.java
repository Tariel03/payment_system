package com.example.dd.services.impl;

import com.example.dd.entities.AppUser;
import com.example.dd.exceptions.NotFoundById;
import com.example.dd.repos.AppUserRepository;
import com.example.dd.services.repo.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElseThrow(
                () -> new NotFoundById("no user by this id")
        );
    }

    @Override
    public void save(AppUser user) {
        appUserRepository.save(user);

    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
