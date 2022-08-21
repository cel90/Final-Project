package com.shoppingapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.orders;
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
  @GetMapping("/{customer_id}") 
  
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
   
  @Operation (
      summary = "Returns a list of orders ",
      description = "Returns a list of all orders" ,
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "List of orders is returned", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = orders.class))),             
          @ApiResponse(responseCode = "404",
              description = "customer not exist ", 
              content = @Content (mediaType = "application/json") ),
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @GetMapping("/all") 
  
  public ResponseEntity<List<orders>> getAll () {
    
    try {
      List<orders> ord = new ArrayList<orders>();
     
      orderService.o().forEach(ord::add);
      if (ord.isEmpty()) {
        return new ResponseEntity<> (HttpStatus.NOT_FOUND) ;
      }
      return new ResponseEntity<> (ord, HttpStatus.OK) ;
    } catch (Exception e) {
      return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }



//@formatter:on 
}
