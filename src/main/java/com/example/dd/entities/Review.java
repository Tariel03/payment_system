package com.example.dd.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String header;

    String description;



    @ManyToOne
    @JoinColumn(name = "appuser")
    AppUser appUser;




}
