package com.shoppingapp.service;

import java.util.List;
import com.shoppingapp.entity.products;
import com.shoppingapp.exceptions.CustomerNotFoundException;

public interface ProductService {

  
  List<products> prdct () throws CustomerNotFoundException;
  int save(String product_name, double price);
  int delete(int product_id);
  int update(int product_id, String product_name, double price);
}
