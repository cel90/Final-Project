package com.shoppingapp.exceptions;

public class CustomerNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CustomerNotFoundException() {
    // TODO Auto-generated constructor stub
  }

  public CustomerNotFoundException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }
}