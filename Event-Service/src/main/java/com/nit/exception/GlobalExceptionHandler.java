package com.nit.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventNotFound(
            EventNotFoundException ex,
            WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Event Not Found")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(VenueNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleVenueNotFound(
            VenueNotFoundException ex,
            WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Venue Not Found")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(VenueNotActiveException.class)
    public ResponseEntity<ErrorResponse> handleVenueNotActive(
            VenueNotActiveException ex,
            WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Venue Not Active")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .badRequest()
                .body(response);
    }

    @ExceptionHandler(InsufficientVenueCapacityException.class)
    public ResponseEntity<ErrorResponse> handleCapacityException(
            InsufficientVenueCapacityException ex,
            WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Insufficient Venue Capacity")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .badRequest()
                .body(response);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            WebRequest request) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error ->
                        error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message(message)
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .badRequest()
                .body(response);
    }
    
    
    @ExceptionHandler(InvalidSeatUpdateException.class)
    public ResponseEntity<ErrorResponse> handleInvalidSeatUpdate(
            InvalidSeatUpdateException ex,
            WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Invalid Seat Update")
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .badRequest()
                .body(response);
    }
    
    
    @ExceptionHandler(feign.FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(
            feign.FeignException ex,
            WebRequest request) {

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.SERVICE_UNAVAILABLE.value())
                .error("Venue Service Unavailable")
                .message("Unable to communicate with Venue Service")
                .path(request.getDescription(false))
                .correlationId(null)
                .build();

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
    
}