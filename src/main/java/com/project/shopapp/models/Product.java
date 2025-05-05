package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
@Data

public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 350)
    private String name;
    private Float price;

    @Column(length = 300)
    private String thumbnail;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    private void onCreate() {
//        createdAt = LocalDateTime.now();
//        updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    private void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
}
