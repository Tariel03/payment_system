package com.example.dd.dto.response;

import com.example.dd.entities.Card;
import jakarta.persistence.Column;

public class BusinessResponse {

    String businessName;
    String businessAddress;
    @Column(unique = true)
    String businessPhoneNumber;
    @Column(unique = true)
    String businessEmail;
    String businessDescription;
    String websiteUrl;
}
