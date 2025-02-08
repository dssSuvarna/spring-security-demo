package com.spring.demo.exceptions;

import com.spring.demo.exceptions.ErrorDetailsWrapper;

public class ErrorUtil {

  public static ErrorDetailsWrapper errorDetails(String errorCode, String errorMessage) {
    ErrorDetailsWrapper errorDetailsWrapper = new ErrorDetailsWrapper();

    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setCode(errorCode);
    errorDetails.setMessage(errorMessage);
    errorDetailsWrapper.setErrors(new ErrorDetails[] {errorDetails});

    return errorDetailsWrapper;
  }

  /**
   * Creates an {@link ErrorDetails} object.
   *
   * @param errorCode the error code representing the type of error
   * @param errorMessage the detailed error message
   * @return an ErrorDetails object with the provided code and message
   */
  public static ErrorDetails returnErrorDetails(String errorCode, String errorMessage) {
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setCode(errorCode);
    errorDetails.setMessage(errorMessage);
    return errorDetails;
  }
}
