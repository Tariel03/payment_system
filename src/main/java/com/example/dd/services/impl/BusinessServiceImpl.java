package com.example.dd.services.impl;

import com.example.dd.dto.request.BusinessRequest;
import com.example.dd.dto.response.BusinessResponse;
import com.example.dd.entities.Business;
import com.example.dd.exceptions.NotFoundById;
import com.example.dd.mappers.BusinessMapper;
import com.example.dd.repos.BusinessRepository;
import com.example.dd.security.RegistrationServiceImpl;
import com.example.dd.services.repo.BusinessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    BusinessRepository businessRepository;
    BusinessMapper businessMapper;
    RegistrationServiceImpl registrationService;
    @Override
    public void save(BusinessRequest request) {
        Business business = businessMapper.toEntity(request);
        business.setAppUser(registrationService.currentUser());
        businessRepository.save(business);

    }

    @Override
    public void save(Business business) {
        businessRepository.save(business);

    }

    @Override
    public BusinessResponse findById(Long id) {
        Optional<Business> optional = businessRepository.findById(id);
        if(optional.isPresent()){
            System.out.println(optional.get());
            return businessMapper.toResponse(optional.get());
        }
        throw new NotFoundById("Not found by id : " + id);
    }
    public Business findRawById(Long id){
        Optional<Business> optional = businessRepository.findById(id);
        if(optional.isPresent()){
            System.out.println(optional.get());
            return optional.get();

        }
        throw new NotFoundById("Not found by id : " + id);
    }
}
