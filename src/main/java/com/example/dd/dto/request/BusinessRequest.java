package com.example.dd.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BusinessRequest {
    String businessName;
    String businessAddress;
    @Column(unique = true)
    String businessPhoneNumber;
    @Column(unique = true)
    String businessEmail;
    String businessDescription;
    String websiteUrl;
}
