package com.shoppingapp.dao;

import java.util.List;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.orders;


public interface OrdersDao {

  List<OrdersByCustomer> ordr (int customer_id) ;
  List<orders> o ();
}
