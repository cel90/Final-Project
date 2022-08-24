package com.shoppingapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingapp.entity.OrdersByCustomer;
import com.shoppingapp.entity.Products;
import com.shoppingapp.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/products")
@OpenAPIDefinition(info = @Info(title = " Shopping app Service"),
                servers = { @Server(url = "http://localhost:8080",
                   description = "Local server.")   })

@RestController
public class ProductsController {

  @Autowired
  ProductService productService ;

//@formatter:off
  
  @Operation (
      summary = "Returns a list of all products ",
      description = "Returns a list of all products " ,
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "List of products is returned", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = Products.class))),             
          @ApiResponse(responseCode = "404",
              description = "Not found", 
              content = @Content (mediaType = "application/json") ),
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @GetMapping("/all") 
  public ResponseEntity<List<Products>> getAllproducts() {
    
    try {
      List<Products> pr = new ArrayList<Products>();
     
      productService.prdct().forEach(pr::add);
      if (pr.isEmpty()) {
        return new ResponseEntity<> (HttpStatus.NOT_FOUND) ;
      }
      return new ResponseEntity<> (pr, HttpStatus.OK) ;
    } catch (Exception e) {
      return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @Operation (
      summary = " Create new product ",
      description = " Create a new product" ,
      responses = {
          @ApiResponse(responseCode = "201", 
              description = " product was created successfully ", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = Products.class))),             
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @PostMapping("/create") 
  public ResponseEntity<String> createProduct(String product_name, double price) {
    
    try {
     
     
      productService.save(product_name, price) ;
     
        return new ResponseEntity<>("product was created successfully ", HttpStatus.CREATED) ;
      
    } catch (Exception e) {
      return new ResponseEntity<> ("An unplanned error occured", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @Operation (
      summary = " delete product by id ",
      description = " delete a product by id" ,
      responses = {
          @ApiResponse(responseCode = "201", 
              description = " product was deleted successfully ", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = Products.class))),  
          @ApiResponse(responseCode = "404",
          description = "Not found", 
          content = @Content (mediaType = "application/json") ),
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @DeleteMapping("/delete{product_id}") 
  public ResponseEntity<String> deleteProduct(int product_id) {
    
    try {
     
     
     int rs =  productService.delete(product_id) ;
     if (rs == 0) {
       return new ResponseEntity<>("no product available ",HttpStatus.NOT_FOUND) ;
     }
        return new ResponseEntity<>("product was deleted successfully ", HttpStatus.CREATED) ;
      
    } catch (Exception e) {
      return new ResponseEntity<> ("An unplanned error occured", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation (
      summary = " update product by id ",
      description = " update a product by id" ,
      responses = {
          @ApiResponse(responseCode = "201", 
              description = " product was updated successfully ", 
              content = @Content (mediaType = "application/json", 
              schema = @Schema(implementation = Products.class))),  
          @ApiResponse(responseCode = "404",
          description = "Not found", 
          content = @Content (mediaType = "application/json") ),
          @ApiResponse(responseCode = "500",
              description = "An unplanned error occured",  
              content = @Content (mediaType = "application/json") )
      }
     
      )
  @PutMapping("/update{product_id}") 
  public ResponseEntity<String> updateProduct(int product_id, String product_name, double price) {
    
    try {
     
     
     int rs =  productService.update(product_id, product_name,  price) ;
     if (rs == 0) {
       return new ResponseEntity<>("no product available ",HttpStatus.NOT_FOUND) ;
     }
        return new ResponseEntity<>("updated successfully !! ",HttpStatus.CREATED) ;
      
    } catch (Exception e) {
      return new ResponseEntity<> ("An unplanned error occured", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
}
