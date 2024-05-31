package com.example.dd.security;

import com.example.dd.entities.AppUser;
import com.example.dd.repos.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> benutzerOptional = appUserRepository.findByUsername(username);
        if(benutzerOptional.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }
        return new AppUserDetails(benutzerOptional.get());
    }
}
