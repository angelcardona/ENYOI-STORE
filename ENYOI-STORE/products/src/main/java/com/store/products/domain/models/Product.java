package com.store.products.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Integer stock;

    public void increaseStock(Long productId, Integer quantity){
        if(this.id.equals(id)){
            this.stock += quantity;
        }else{
            throw  new IllegalArgumentException("Product ID does not match");
        }
    }
    public void decreaseStock(Long productId,Integer quantity){
        if(this.id.equals(id)){
            this.stock -= quantity;
        }else{
            throw  new IllegalArgumentException("Product ID does not match");
        }
    }
    
   

}
