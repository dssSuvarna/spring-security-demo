package com.spring.demo.exceptions;

import lombok.Data;

/** Wrapper class for holding multiple error details. */
@Data
public class ErrorDetailsWrapper {

  /** Array of error details for representing multiple errors. */
  private ErrorDetails[] errors;
}
