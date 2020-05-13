package com.example.shop.service;

import com.example.shop.domain.jpa.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    @CachePut(cacheNames = "product", key = "#result.id")
    Product save(Product product);
    @Cacheable(cacheNames = "product", key = "#id")
    Product searchById(Long id);
    @CacheEvict(cacheNames = "product", key = "#id")
    void deleteProductById(Long id);
    Page<Product> getPage(Pageable pageable);
    void uploadImage(MultipartFile file);

}
