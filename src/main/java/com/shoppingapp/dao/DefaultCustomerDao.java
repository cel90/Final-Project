package com.shoppingapp.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shoppingapp.entity.customer;


@Service

public class DefaultCustomerDao implements CustomerDao {

  @Autowired
  // private NamedParameterJdbcTemplate jdbcTemplate ; 
  private JdbcTemplate jdbcTemplate ;
  
  @Override
  public List<customer> cstmr() { 
  //  log.debug("DAO: id={} ", id);
  // @formatter:off
 // String sql = ""
   //   +"SELECT * "
   //   +"FROM customer "
    //  +"WHERE customer_id = :customer_id " ;   
  // @formatter:on
 // Map<String, Object> params = new HashMap<>() ;
  
 // params.put("customer_id", id) ;
// select c.customer_id, c.first_name, c.last_name, c.phone, o.order_id from customer c left join  orders o on  c.customer_id = o.customer_id  where o.order_id is not null
 return  jdbcTemplate.query("select c.customer_id, c.first_name, c.last_name, c.phone, o.order_id from customer c left join  orders o on  c.customer_id = o.customer_id  where o.order_id ", BeanPropertyRowMapper.newInstance(customer.class)) ;
 
  //  return jdbcTemplate.query("select c.customer_id, c.first_name, c.last_name, c.phone, o.order_id from customer c left join  orders o on  c.customer_id = o.customer_id" ,
      //  new RowMapper<> () {
     // @Override
     // public customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        
     //   return customer.builder()
       //     .customer_id(rs.getInt("customer_id"))
       //     .first_name(rs.getString("first_name"))
        //    .last_name(rs.getString("last_name"))
         //   .phone(rs.getString("phone"))
         //   .order_id(rs.getInt("order_id"))
         //   .build();     
           
        // @formatter:on
          //}} ) ;
  } }
  

