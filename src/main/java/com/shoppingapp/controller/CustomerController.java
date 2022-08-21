package com.shoppingapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.dao.CustomerDao;
import com.shoppingapp.entity.customer;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.service.CustomerService;
import com.shoppingapp.service.OrdersService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/customer")
@OpenAPIDefinition(info = @Info(title = " Shopping app Service"),
                servers = { @Server(url = "http://localhost:8080",
                   description = "Local server.")   })

@RestController
 
public class CustomerController {
    //@Autowired 
      // CustomerDao cDao ;
    @Autowired
       CustomerService customerService ;
     

    //@formatter:off 
      @Operation (
          summary = "Returns a list of customers ",
          description = "Returns a list of all exist customers who having orders  " ,
          responses = {
              @ApiResponse(responseCode = "200", 
                  description = "List of customers is returned", 
                  content = @Content (mediaType = "application/json", 
                  schema = @Schema(implementation = customer.class))),             
              @ApiResponse(responseCode = "404",
                  description = "customers Not found", 
                  content = @Content (mediaType = "application/json") ),
              @ApiResponse(responseCode = "500",
                  description = "An unplanned error occured",  
                  content = @Content (mediaType = "application/json") )
          }
         
          )
// private CustomerService customerService ;
// @Override
 
 //public List<customer> ctmr  throws CustomerNotFoundException {
   // TODO Auto-generated method stub
   //log.info("id={}", id);
 //  return customerService.cstmr();
 
     @GetMapping("/allcustomers") 
public ResponseEntity<List<customer>> getAll () {
  try {
    List<customer> cust = new ArrayList<customer>();
   
    customerService.cstmr().forEach(cust::add);
    if (cust.isEmpty()) {
      return new ResponseEntity<> ( HttpStatus.NOT_FOUND) ;
    }
    return new ResponseEntity<> (cust, HttpStatus.OK) ;
  } catch (Exception e) {
    return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
 
}
      
     
       
  
 
 
    //@formatter:on  
  
}
