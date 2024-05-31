package com.example.dd.services.repo;

import com.example.dd.dto.request.BusinessRequest;
import com.example.dd.dto.response.BusinessResponse;
import com.example.dd.entities.Business;

public interface BusinessService {
    void save(BusinessRequest request);
    void save(Business business);
    BusinessResponse findById(Long id);

}
