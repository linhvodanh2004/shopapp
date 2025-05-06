package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ProductDTO {
    @NotBlank(message = "Product name is required")
    @Size(min = 5, max = 200, message = "Product name should have length from 5 to 200")
    private String name;

    @Min(value = 0, message = "Price is greater than 0")
    @Max(value = 1000000, message = "Price is less than 10,000,000")
    private float price;

    private String thumbnail;
    private String description;
    @JsonProperty("category_id") // Use JsonProperty for mapping to database
    private Long categoryId;

    private List<MultipartFile> files;
}
