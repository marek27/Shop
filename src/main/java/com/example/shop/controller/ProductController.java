package com.example.shop.controller;

import com.example.shop.domain.dto.ProductDto;
import com.example.shop.domain.jpa.Product;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productMapper.productToProductDto(productService.save(productMapper.productDtoToProduct(productDto)));
    }

    @GetMapping("/{productId}")
    public ProductDto searchProductById(@PathVariable Long productId) {
        return productMapper.productToProductDto(productService.searchById(productId));
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }

}
