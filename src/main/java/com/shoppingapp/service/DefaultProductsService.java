package com.shoppingapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingapp.dao.ProductDao;
import com.shoppingapp.entity.products;

@Service
public class DefaultProductsService implements ProductService {
  @Autowired
  private  ProductDao productDao ;
  
  public List<products> prdct()  {
    
    List<products> pr = productDao.prdct()   ;
        return pr ;
  }
  public int save ( String product_name, double price) {
   int svpr = productDao.save(product_name,price ) ;
   return svpr ;
  }
  public int delete (int product_id) {
   return productDao.delete(product_id) ;
  }
  public int update (int product_id,String product_name, double price) {
    return productDao.update(product_id, product_name, price ) ;
   }
}
