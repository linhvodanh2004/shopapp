package com.project.shopapp.controllers;

import com.project.shopapp.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok("Get all products");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        return ResponseEntity.status(HttpStatus.OK).body("Get product with id " + productId);
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> insertProduct(@Valid @ModelAttribute ProductDTO productDTO
            , BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors()
                        .stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errors);
            }
            List<MultipartFile> multipartFiles = productDTO.getFiles();
            // create new files in case input file is null
            multipartFiles = multipartFiles == null ? new ArrayList<MultipartFile>() : multipartFiles;
            for (MultipartFile multipartFile : multipartFiles) {
                // continue if file size is 0
                if (multipartFile.getSize() == 0) {
                    continue;
                }
                if (multipartFile.getSize() > 10 * 1024 * 1024) {
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("The size of image is too large");
                }
                String contentType = multipartFile.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("The file must be image");
                }
                String fileName = storeFile(multipartFile);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Add new product successfully: " + productDTO.getName());


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private String storeFile(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uniqueName = UUID.randomUUID().toString() + "_" + fileName;
        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        Path destination = Paths.get(uploadDir.toString(), uniqueName);
        Files.copy(multipartFile.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueName;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id) {
        return ResponseEntity.ok("Test updating product " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok("Test delete product " + id);
    }
}
