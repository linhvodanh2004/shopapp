package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {

    @PostMapping("")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDTO orderDTO
            , BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors()
                        .stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errors);
            }
            return ResponseEntity.ok("Create order successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable("id") Long userId) {
        try {
             return ResponseEntity.ok("Get orders by user id " + userId);
         } catch (Exception e) {
             return ResponseEntity.badRequest().body(e.getMessage());
         }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@Valid @PathVariable Long id, @Valid @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok("Test updating order " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@Valid @PathVariable Long id) {
        return ResponseEntity.ok("Test delete order " + id);
    }
}
