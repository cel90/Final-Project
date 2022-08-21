package com.shoppingapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class products {


 
  private int product_id ; 
  private String product_name ;
   private double price ;
   
   @JsonIgnore 
   public int getproductid() {
    
     
     return product_id ;
     
     
   }
}
