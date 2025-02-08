package com.spring.demo.exceptions;

import lombok.Data;

/** Represents the details of an error, including an error code and message. */
@Data
public class ErrorDetails {

  /** The error code representing the type of error. */
  private String code;

  /** The detailed error message. */
  private String message;
}
