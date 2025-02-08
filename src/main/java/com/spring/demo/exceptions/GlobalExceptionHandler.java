package com.spring.demo.exceptions;

import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler for handling and centralizing exceptions across the application.
 *
 * <p>This class uses {@link RestControllerAdvice} to intercept exceptions thrown by controllers and
 * return a standardized error response. It logs errors for debugging purposes and provides
 * meaningful error details to clients.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetailsWrapper> handleGenericException(Exception ex) {
    // Log the error with details
    LOGGER.error("Exception occurred: {}", ex.getMessage(), ex);

    return new ResponseEntity<>(
        ErrorUtil.errorDetails("ERR_1001", ex.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDetailsWrapper> handleValidationException(
      MethodArgumentNotValidException e, WebRequest request) {
    // Extract error details from the validation errors
    String errorDetails =
        e.getBindingResult().getAllErrors().stream()
            .map(error -> error.getDefaultMessage())
            .collect(Collectors.joining(", "));

    // Log the validation error details
    LOGGER.error("Validation exception occurred: {}", errorDetails, e);

    // Build the error response
    ErrorDetailsWrapper errorDetailsWrapper =
        ErrorUtil.errorDetails(
            String.valueOf(HttpStatus.BAD_REQUEST.value()), "Validation failed: " + errorDetails);

    return new ResponseEntity<>(errorDetailsWrapper, HttpStatus.BAD_REQUEST);
  }
}
