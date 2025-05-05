package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class OrderDetailDTO {

    @JsonProperty("order_id")
    @Min(value = 1, message = "Order id must be greater than 0")
    private Long orderId;

    @JsonProperty("product_id")
    @Min(value = 1, message = "Product id must be greater than 0")
    private Long productId;

    @Min(value = 0, message = "Quantity must be greater than or equal 0")
    private Long price;

    @Min(value = 1, message = "Quantity  must be greater than 0")
    @JsonProperty("number_of_products")
    private int numberOfProducts;

    @Min(value = 0, message = "Total money must be greater than or equal 0")
    @JsonProperty("total_money")
    private int totalMoney;

    private String color;
}
