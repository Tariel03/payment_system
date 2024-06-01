package com.example.dd.controllers;

import com.example.dd.dto.request.BusinessRequest;
import com.example.dd.dto.response.BusinessResponse;
import com.example.dd.entities.Business;
import com.example.dd.repos.BusinessRepository;
import com.example.dd.services.impl.BusinessServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/business")
@Tag(name = "Business")
public class BusinessController {

    BusinessServiceImpl businessService;
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody BusinessRequest businessRequest){
        businessService.save(businessRequest);
        return ResponseEntity.ok("Successfully added");
    }
    @GetMapping("/all")
    public List<Business> findAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());
        return businessService.findAll();
    }

    @PostMapping("/string")
    public String string(@RequestParam String s){
        return s;
    }

    @GetMapping("/{id}")
    public Business findById(@PathVariable Long id){
        return businessService.findRawById(id);
    }


}
