package com.shoppingapp.service;

import java.util.List;
import com.shoppingapp.entity.customer;
import com.shoppingapp.exceptions.CustomerNotFoundException;

public interface CustomerService {

  List<customer> cstmr () throws CustomerNotFoundException;
}
