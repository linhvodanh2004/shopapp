package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order-details")
public class OrderDetailController {

    // ADd new Order detail
    @PostMapping("")
    public ResponseEntity<?> createOrderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTO
    ) {
        return ResponseEntity.ok("Create order detail successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Get order detail by id " + id);
    }

    // get order details by order Id
    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrderDetailsByOrderId(@PathVariable("id") Long orderId) {
        return ResponseEntity.ok("Get order details by order id " + orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@Valid @PathVariable Long id
            , @Valid @RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.ok("Update order detail " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@Valid @PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
