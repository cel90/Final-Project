package com.shoppingapp.service;

public interface OrderProductService {

  int insert(int quantity, int order, int product );
  int insert1(int order,int customer) ;
  int deleteorder(int order);
}
