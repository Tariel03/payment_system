package com.example.dd.security;

import com.example.dd.dto.request.UserRequest;
import com.example.dd.entities.AppUser;
import com.example.dd.enums.Role;
import com.example.dd.repos.AppUserRepository;
import com.example.dd.repos.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    AppUserRepository  appUserRepository;
    PasswordEncoder passwordEncoder;
    public Optional<AppUser> login(UserRequest userRequest) {
        return Optional.empty();
    }

    @Override
    public void registration(AppUser appUser) {

    }
    public void registration(UserRequest userRequest) {
        String pass = passwordEncoder.encode(userRequest.getPassword());
        userRequest.setPassword(pass);
        AppUser appUser =
                AppUser.builder()
                        .name(userRequest.getName())
                        .username(userRequest.getUsername())
                        .password(userRequest.getPassword())
                        .build();
        appUser.setRole(Role.USER);
        appUserRepository.save(appUser);
    }

    @Override
    public void save(AppUser appUser) {

    }
}
