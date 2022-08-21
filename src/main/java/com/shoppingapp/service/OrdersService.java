package com.shoppingapp.service;

import java.util.List;

import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.orders;
import com.shoppingapp.exceptions.CustomerNotFoundException;

public interface OrdersService {
  List<OrdersByCustomer> ordr (int customer_id) throws CustomerNotFoundException;
  List<orders> o () throws CustomerNotFoundException;
}
