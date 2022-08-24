package com.shoppingapp.service;

import java.util.List;
import com.shoppingapp.entity.Customer;
import com.shoppingapp.exceptions.CustomerNotFoundException;

public interface CustomerService {

  List<Customer> cstmr () throws CustomerNotFoundException;
}
