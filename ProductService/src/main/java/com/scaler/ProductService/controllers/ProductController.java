package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.ProductResponseDto;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/product/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id) {
        Product product = this.productService.GetProductById(id);
        return  ProductResponseDto.from(product);
    }

    @GetMapping("/products")
    public String getAllProducts() {
        return  "products";
    }

    public void createProduct() {

    }

    public void deleteProduct() {

    }

}
