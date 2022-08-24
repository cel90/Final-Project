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
public class Order_product {

  
 private  int id  ;
  private int quantity ;
  private int order ;
  private int product ;
  private int customer ;
  
 // private 
  
  @JsonIgnore 
  public int getorderproductid() {
   
    
    return id ;
    
    
  }
}
