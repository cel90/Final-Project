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
public class OrdersByCustomer {
   
   private int order_id ;
   private int customer_id ;
   private String first_name ;
   private String last_name ;
   private String product_name ;
   private int quantity ;
   
   
  @JsonIgnore 
  public int getorderid() {
   
    
    return order_id ;
    
    
  }
}
