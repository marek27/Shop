package com.example.shop.service.impl;

import com.example.shop.domain.jpa.Product;
import com.example.shop.repository.jpa.ProductRepository;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product searchById(Long id) {
        log.info("product with id {} not in cache",id);
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product with id" + id + " dosnt exist"));
    }

    @Override
    public void deleteProductById(Long id) {
            productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void uploadImage(MultipartFile file) {

    }
}
