package com.example.ktm.exception;

import com.example.ktm.enums.Types;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.ktm.constants.AppConst.HANDLED_EXCEPTION;
import static com.example.ktm.constants.AppConst.LOG_EXCEPTION;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final ErrorMessages errorMsg;

    public GlobalExceptionHandler(ErrorMessages errorMsg) {
        this.errorMsg = errorMsg;
    }

    // Handle custom exceptions
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiError> handleAppException(AppException ex) {

        // Resolve message from YAML using category + code + params
        String msg = errorMsg.getMessage(ex.getCategory(), ex.getCode(), ex.getParams());

        ApiError error = ApiError.builder()
                .code(ex.getCode())
                .error(HANDLED_EXCEPTION)
                .message(msg)
                .category(ex.getCategory())
                .build();

        // Log full stack trace internally
        log.error(LOG_EXCEPTION, ex);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAllExceptions(Exception ex) {

        // Get message from error.yml file
        String msg = errorMsg.getMessage(Types.Errors.internal.name(), 1000);

        ApiError error = ApiError.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(msg)
                .build();

        // Log full stack trace internally
        log.error(LOG_EXCEPTION, ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
