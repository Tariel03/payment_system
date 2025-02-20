package com.example.dd.entities;

import com.example.dd.enums.Role;
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
public class AppUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @Enumerated(EnumType.STRING)
    Role role;
    @Column(unique = true)
    String username;
    String password;
    String name;





}
