package com.example.dd.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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

    LocalDateTime writtenTime;

    @ManyToOne
    @JoinColumn(name = "appuser")
    AppUser appUser;

    @PrePersist
    private void prePersist() {
        writtenTime = LocalDateTime.now();
    }


}
