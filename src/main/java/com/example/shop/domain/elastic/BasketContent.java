package com.example.shop.domain.elastic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.List;

@Document(indexName = "basket_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketContent {

    @Id
    private String id;
    private Long userId;
    private List<ProductContent> products;

}
