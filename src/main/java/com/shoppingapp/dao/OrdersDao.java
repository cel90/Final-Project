package com.shoppingapp.dao;

import java.util.List;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.Orders;


public interface OrdersDao {

  List<OrdersByCustomer> ordr (int customer_id) ;
 
  int delete(int cstmr);
}
