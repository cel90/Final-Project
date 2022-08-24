package com.shoppingapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shoppingapp.entity.Products;

@Service
public class DefaultProductDao implements ProductDao {
  @Autowired
  private JdbcTemplate jdbcTemplate ;
  @Override
  public List<Products> prdct() {
    
    return  jdbcTemplate.query("select * from products ", BeanPropertyRowMapper.newInstance(Products.class)) ; 
    
  }
  @Override
 
  public int save (String product_name, double price) {
    
    
    return jdbcTemplate.update("insert into products (product_name,price) values (?,?)",product_name, price) ;
      
       
    
  }
  @Override
  public int delete(int product_id) {
    return jdbcTemplate.update("delete from products where product_id = ? ",product_id) ;
    
 }
  @Override
  public int update(int product_id, String product_name, double price) {
    return jdbcTemplate.update("update products set product_name = ? , price = ? where product_id = ?",product_name,price,product_id) ;
    
 }
  
}
