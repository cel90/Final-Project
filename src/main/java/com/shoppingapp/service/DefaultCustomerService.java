package com.shoppingapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingapp.dao.CustomerDao;
import com.shoppingapp.entity.customer;

@Service

public class DefaultCustomerService implements CustomerService {

  @Autowired
  
  private CustomerDao customerDao ;
  
  public List<customer> cstmr()  {
 
    List<customer> customers = customerDao.cstmr()   ;
        return customers ;
  }


}
