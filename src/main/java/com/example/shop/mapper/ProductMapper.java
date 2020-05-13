package com.example.shop.mapper;


import com.example.shop.domain.dto.ProductDto;
import com.example.shop.domain.jpa.Product;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto productToProductDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .prize(product.getPrize())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .id(product.getId())
                .build();
    }

    public Product productDtoToProduct( ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .prize(productDto.getPrize())
                .description(productDto.getDescription())
                .quantity(productDto.getQuantity())
                .id(productDto.getId())
                .build();
    }

    public List<ProductDto> userListToUserListDto(List<Product> products) {
        return products.stream()
                .map(this::productToProductDto)
                .collect(Collectors.toList());
    }
}