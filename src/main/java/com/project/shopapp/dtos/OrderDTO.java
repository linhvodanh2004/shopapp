package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data

public class OrderDTO {
    @JsonProperty("user_id")
    @Min(value = 1, message = "User id must be greater than 0")
    private Long userId;

    @JsonProperty("fullname")
    private String fullName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email is invalid")
    private String email;

    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[+]?[0-9]{10,13}$", message = "Phone number is invalid")
    private String phoneNumber;

    private String address;
    private String note;

    @JsonProperty("total_money")
    @Min(value = 0, message = "Total money must be greater than 0")
    private Float totalMoney;

    @JsonProperty("shipping_method")
    private String shippingMethod;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("payment_method")
    private String paymentMethod;
}
