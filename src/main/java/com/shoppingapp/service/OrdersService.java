package com.shoppingapp.service;

import java.util.List;

import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.Orders;
import com.shoppingapp.exceptions.CustomerNotFoundException;

public interface OrdersService {
  List<OrdersByCustomer> ordr (int customer_id) ;
  int delete(int cstmr)  ;
}
