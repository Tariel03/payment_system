package com.example.dd.repos;

import com.example.dd.entities.AppUser;
import com.example.dd.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Optional<Business> findByBusinessEmail(String email);
    Optional<Business>findByAppUser(AppUser user);

}
