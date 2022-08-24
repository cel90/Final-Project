package com.shoppingapp.service;

import java.util.List;
import com.shoppingapp.entity.Products;
import com.shoppingapp.exceptions.CustomerNotFoundException;

public interface ProductService {

  
  List<Products> prdct () throws CustomerNotFoundException;
  int save(String product_name, double price);
  int delete(int product_id);
  int update(int product_id, String product_name, double price);
}
