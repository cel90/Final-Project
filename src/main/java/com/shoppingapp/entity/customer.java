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
public class Customer {

  private int customer_id ;
  private String first_name ; 
  private String last_name ;
  private String phone ;
  
  @JsonIgnore 
  public int getcustomerid() {
   
    
    return customer_id ;
    
    
  }
}
