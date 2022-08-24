package com.shoppingapp.dao;

public interface OrderProductDao {

  
  int insert(int quantity, int order, int product );

  int insert1(int order, int customer);

  int deleteOrder(int order);
}
