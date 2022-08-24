package com.shoppingapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderProduct implements OrderProductDao{
  @Autowired
  private JdbcTemplate jdbcTemplate ;
  @Override
  
 public int insert(int quantity, int order, int product ) {
    
    
    return jdbcTemplate.update("insert into order_product (quantity,order_id,product_id) values (?,?,?) ;",quantity, order, product) ;
      
       
    
  }
  @Override
  public int insert1(int order, int customer) {
    
    return jdbcTemplate.update("insert into orders values (?,?)", order, customer) ;
  }
   public int deleteOrder(int order) {
     return jdbcTemplate.update("delete from orders where order_id = ? ;", order) ;
   }
}
