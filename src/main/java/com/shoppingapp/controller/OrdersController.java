package com.shoppingapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.Products;
import com.shoppingapp.entity.Order_product;
import com.shoppingapp.entity.Orders;
import com.shoppingapp.service.OrderProductService;
import com.shoppingapp.service.OrdersService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = " Shopping app Service"),
                servers = { @Server(url = "http://localhost:8080",
                   description = "Local server.")   })

@RestController
public class OrdersController {
  @Autowired
  
    OrdersService orderService ;
  @Autowired
  OrderProductService orderProductService ;

//@formatter:off
  
  @Operation (
      summary = "Returns a list of orders by customer id",
     description = "Returns a list of all orders of a choosen customer " ,
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "List of orders is returned", 
             content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = OrdersByCustomer.class))),             
          @ApiResponse(responseCode = "404",
              description = "customer doesn't exist ", 
              content = @Content (mediaType = "application/json") ),
          @ApiResponse(responseCode = "500",
              description = "internal Server Error or customer doesnt have order yet ",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @GetMapping("/order{customer_id}") 
  
  public ResponseEntity<List<OrdersByCustomer>> getAllorders (int customer_id) {
    
    try {
      List<OrdersByCustomer> o = new ArrayList<OrdersByCustomer>();
     
      orderService.ordr(customer_id).forEach(o::add);
      if (o.isEmpty()) {
        return new ResponseEntity<> (HttpStatus.NOT_FOUND) ;
      }
      return new ResponseEntity<> (o, HttpStatus.OK) ;
    } catch (Exception e) {
      return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
   
  
//@formatter:off
  @Operation (
      summary = " Create new order ",
      description = " Create a new order" ,
      responses = {
          @ApiResponse(responseCode = "201", 
              description = " order was created successfully ", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = Order_product.class))),             
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured or Customer id doesn't exist or Product id doesn't exist or order id already used",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @PostMapping("/createorder") 
  public ResponseEntity<String> makeOrder( int customer,int order, int product,  int quantity) {
    
    try {
     
      orderProductService.insert1(order, customer) ;
     orderProductService.insert(quantity, order, product) ;
      
      
     
        return new ResponseEntity<>(HttpStatus.CREATED) ;
      
    } catch (Exception e) {
      orderProductService.deleteorder(order) ;
      return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
//@formatter:on
//@formatter:off
  @Operation (
      summary = " Delete order by customer id ",
      description = " Delete an order of a choosen customer " ,
      responses = {
          @ApiResponse(responseCode = "201", 
              description = " order was deleted successfully ", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = Orders.class))),
          @ApiResponse(responseCode = "404",
          description = "Not found", 
          content = @Content (mediaType = "application/json") ),
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured",  
              content = @Content (mediaType = "application/json")
          )
      }
     
      )
  @DeleteMapping("/deleteorder{cstmr}") 
  public ResponseEntity<String> DeleteOrder(int cstmr) {
    
    try {
     
      int rs = orderService.delete(cstmr) ;
    
      
      if (rs == 0) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
      }
        
     
        return new ResponseEntity<>( HttpStatus.CREATED) ;
      
    } catch (Exception e) {
      return new ResponseEntity<> ( HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
//@formatter:on
}
