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
public class customer {

  private int customer_id ;
  private String first_name ; 
  private String last_name ;
  private String phone ;
  
  //@MappedCollection (keyColumn = "order_id", idColumn = "customer_id")
 // private int order_id ;
  @JsonIgnore 
  public int getcustomerid() {
   
    
    return customer_id ;
    
    
  }
}
