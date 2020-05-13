package com.example.shop.service.impl;

import com.example.shop.repository.elastic.BasketRepository;
import com.example.shop.service.BasketService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
}
