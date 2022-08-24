package com.shoppingapp.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.Orders;


@Service

public class DefaultOrdersDao implements OrdersDao {

  @Autowired
  private JdbcTemplate jdbcTemplate ;
// private  NamedParameterJdbcTemplate jdbcTemplate2 ;
  @Override
  public List<OrdersByCustomer> ordr(int customer_id) {
    
    
   // return  jdbcTemplate.query("select * from orders ", BeanPropertyRowMapper.newInstance(orders.class)) ;
  
    return jdbcTemplate.query("select o.order_id,c.customer_id, c.first_name, c.last_name, p.product_name, op.quantity  from customer c left join orders o on c.customer_id = o.customer_id left join order_product op on o.order_id = op.order_id left join products p on op.product_id = p.product_id where c.customer_id = ?" ,BeanPropertyRowMapper.newInstance(OrdersByCustomer.class),customer_id ) ;
  
  }

  @Override
  
  public int delete(int cstmr) {
    return jdbcTemplate.update("delete from orders where customer_id = ?" ,cstmr ) ;
  }
  
  
}

