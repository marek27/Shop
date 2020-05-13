package com.example.shop.repository.elastic;

import com.example.shop.domain.elastic.BasketContent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BasketRepository extends ElasticsearchRepository<BasketContent, String> {
}
