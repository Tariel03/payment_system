package com.example.dd.repos;

import com.example.dd.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
