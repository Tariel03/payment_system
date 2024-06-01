package com.example.dd.mappers;

import com.example.dd.dto.request.BusinessRequest;
import com.example.dd.dto.response.BusinessResponse;
import com.example.dd.entities.Business;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-01T06:50:48+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (JetBrains s.r.o.)"
)
@Component
public class BusinessMapperImpl implements BusinessMapper {

    @Override
    public Business toEntity(BusinessRequest request) {
        if ( request == null ) {
            return null;
        }

        Business.BusinessBuilder business = Business.builder();

        business.businessName( request.getBusinessName() );
        business.businessAddress( request.getBusinessAddress() );
        business.businessPhoneNumber( request.getBusinessPhoneNumber() );
        business.businessEmail( request.getBusinessEmail() );
        business.businessDescription( request.getBusinessDescription() );
        business.websiteUrl( request.getWebsiteUrl() );

        return business.build();
    }

    @Override
    public Business toEntity(BusinessResponse response) {
        if ( response == null ) {
            return null;
        }

        Business.BusinessBuilder business = Business.builder();

        return business.build();
    }

    @Override
    public BusinessResponse toResponse(Business business) {
        if ( business == null ) {
            return null;
        }

        BusinessResponse businessResponse = new BusinessResponse();

        return businessResponse;
    }

    @Override
    public BusinessRequest toRequest(Business business) {
        if ( business == null ) {
            return null;
        }

        BusinessRequest.BusinessRequestBuilder businessRequest = BusinessRequest.builder();

        businessRequest.businessName( business.getBusinessName() );
        businessRequest.businessAddress( business.getBusinessAddress() );
        businessRequest.businessPhoneNumber( business.getBusinessPhoneNumber() );
        businessRequest.businessEmail( business.getBusinessEmail() );
        businessRequest.businessDescription( business.getBusinessDescription() );
        businessRequest.websiteUrl( business.getWebsiteUrl() );

        return businessRequest.build();
    }

    @Override
    public List<BusinessResponse> toListResponse(List<Business> list) {
        if ( list == null ) {
            return null;
        }

        List<BusinessResponse> list1 = new ArrayList<BusinessResponse>( list.size() );
        for ( Business business : list ) {
            list1.add( toResponse( business ) );
        }

        return list1;
    }
}
