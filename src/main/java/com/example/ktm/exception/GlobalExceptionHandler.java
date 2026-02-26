package com.example.ktm.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle custom exceptions
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiError> handleAppException(AppException ex, ErrorMessages errorMessages) {

        // Resolve message from YAML using category + code + params
        String msg = errorMessages.getMessage(ex.getCategory(), String.valueOf(ex.getCode()), ex.getParams());

        ApiError error = ApiError.builder()
                .status(ex.getCode())
                .error("Application Error")
                .message(msg)
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiError> handleAllExceptions(Exception ex, HttpServletRequest request) {
//
//        ApiError error = ApiError.builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())          // 500
//                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()) // "Internal Server Error"
//                .message("Something went wrong. Please contact support.")  // message
//                .build();
//
//        // Log full stack trace internally
//        log.error("Exception : ", ex);
//        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
