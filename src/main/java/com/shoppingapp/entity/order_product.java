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
public class order_product {

  
 private  int id  ;
  private int quantity ;
 // private 
  
  @JsonIgnore 
  public int getorderproductid() {
   
    
    return id ;
    
    
  }
}
