package com.example.shop.domain.elastic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductContent {

   private Long id;
   private Double price;
   private Double quantity;
   private String name;

}
