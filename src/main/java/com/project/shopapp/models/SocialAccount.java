package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "social_accounts")
@Data

public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String provider;

    @Column(name = "provider_id", nullable = false, length = 50)
    private String providerId;

    @Column(length = 150)
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
