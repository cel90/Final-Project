package com.shoppingapp.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {
  @NotNull
  @Pattern(regexp = "[\\w\\s]*")

 
  private int product_id ; 
  
  private String product_name ;
   private double price ;
   
   @JsonIgnore 
   public int getproductid() {
    
     
     return product_id ;
     
     
   }
}
