package com.shoppingapp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.shoppingapp.entity.OrdersByCustomer;


@Service

public class DefaultOrdersDao implements OrdersDao {

  @Autowired
  private JdbcTemplate jdbcTemplate ;
// private  NamedParameterJdbcTemplate jdbcTemplate2 ;
  @Override
  public List<OrdersByCustomer> ordr(int customer_id) {
    
    
   // return  jdbcTemplate.query("select * from orders ", BeanPropertyRowMapper.newInstance(orders.class)) ;
  
    return jdbcTemplate.query("select o.order_id,c.customer_id, c.first_name, c.last_name, p.product_name, op.quantity  from customer c inner join orders o on c.customer_id = o.customer_id inner join order_product op on o.order_id = op.order_id inner join products p on op.product_id = p.product_id where c.customer_id = ?" ,BeanPropertyRowMapper.newInstance(OrdersByCustomer.class),customer_id ) ;
  
  }

  @Override
  
  public int delete(int cstmr) {
    return jdbcTemplate.update("delete from orders where customer_id = ?" ,cstmr ) ;
  }
  
  
}

