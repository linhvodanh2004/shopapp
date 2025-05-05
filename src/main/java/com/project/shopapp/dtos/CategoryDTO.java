package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class CategoryDTO {
    @NotEmpty(message = "Category name must not be empty")
    private String name;

//    public String getName() {
//        return name;
//    }
//    public void setName(String name1){
//        name = name1;
//    }
}
