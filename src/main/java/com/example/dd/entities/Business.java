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
    @ManyToOne
    @JoinColumn(name = "card")
    Card card;
    @ManyToOne
    @JoinColumn(name = "appUser")
    AppUser appUser;
    String businessName;
    String businessAddress;
    @Column(unique = true)
    String businessPhoneNumber;
    @Column(unique = true)
    String businessEmail;
    @Column(columnDefinition = "TEXT")
    String businessDescription;
    String websiteUrl;




}
