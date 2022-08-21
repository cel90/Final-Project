package com.shoppingapp.dao;

import java.util.List;
import com.shoppingapp.entity.products;

public interface ProductDao {

  List<products> prdct () ;

  int save(String product_name, double price);
  int delete(int product_id) ;

  int update(int product_id, String product_name, double price);
}
