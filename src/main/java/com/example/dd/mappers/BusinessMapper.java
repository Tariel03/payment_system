package com.example.dd.mappers;

import com.example.dd.dto.request.BusinessRequest;
import com.example.dd.dto.response.BusinessResponse;
import com.example.dd.entities.Business;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    Business toEntity(BusinessRequest request);
    Business toEntity(BusinessResponse response);
    BusinessResponse toResponse(Business business);
    BusinessRequest toRequest(Business business);
    List<BusinessResponse> toListResponse(List<Business> list);




}
