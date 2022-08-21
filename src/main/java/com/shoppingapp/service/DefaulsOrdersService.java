package com.shoppingapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingapp.dao.OrdersDao;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.orders;

@Service
public class DefaulsOrdersService implements OrdersService {

  @Autowired
   private OrdersDao orderDao ;
  
   public List<OrdersByCustomer> ordr(int customer_id)  {
     
     List<OrdersByCustomer> orders = orderDao.ordr( customer_id)   ;
         return orders ;
   }
 public List<orders> o ()  {
     
     List<orders> or = orderDao.o()   ;
         return or ;
   }
}
