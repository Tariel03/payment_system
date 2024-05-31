package com.example.dd.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne
    @JoinColumn(name = "card")
    Card card;
    @OneToOne
    @JoinColumn(name = "appUser")
    AppUser appUser;
    String businessName;
    String businessAddress;
    String businessPhoneNumber;
    String businessEmail;
    String businessType;
    String businessCategory;
    String businessDescription;
    String websiteUrl;




}
