package com.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingapp.dao.OrderProductDao;

@Service
public class DefaultOrderProductService implements OrderProductService{
  @Autowired
  private OrderProductDao orderProductDao ;
  public int insert(int quantity, int order, int product ) {
    int insrt = orderProductDao.insert(quantity, order, product) ;
    
    return insrt ;
  }
  public int insert1(int order, int customer) {
    int insrt1 = orderProductDao.insert1(order, customer) ;
    return insrt1 ;
  }
  public  int deleteorder(int order) {
    
    int deleteodr = orderProductDao.deleteOrder(order) ;
    return deleteodr ;
  }
}
