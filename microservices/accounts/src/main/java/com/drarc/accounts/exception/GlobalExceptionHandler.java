package com.drarc.accounts.exception;

import com.drarc.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // This annotation allows the class to globally handle exceptions for all controllers.
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Generic exception handler for any uncaught exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handle(Exception ex, WebRequest request) {
        // Create an error response DTO with details about the error
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                request.getDescription(false), // Get request description
                HttpStatus.INTERNAL_SERVER_ERROR, // Set the HTTP status code as 500 Internal Server Error
                ex.getMessage(), // Set the exception message
                LocalDateTime.now() // Capture the current timestamp
        );
        // Return the response entity with the error response and the 500 status code
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Exception handler for when a customer already exists
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex, WebRequest request) {
        // Create a specific error response for CustomerAlreadyExistsException
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.BAD_REQUEST, // Set the HTTP status code as 400 Bad Request
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Exception handler for when a requested resource is not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        // Create a specific error response for ResourceNotFoundException
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.NOT_FOUND, // Set the HTTP status code as 404 Not Found
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Overriding the default handler to customize validation errors
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        Map<String, String> validationErrors = new HashMap<>();
        // Iterate over the validation errors in the request and populate them into a map
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField(); // Get the field name that caused the error
            String errorMessage = error.getDefaultMessage(); // Get the default validation error message
            validationErrors.put(fieldName, errorMessage); // Add field name and message to the map
        });

        // Return the map of validation errors with the 400 Bad Request status code
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }
}
