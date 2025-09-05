package com.learning.hotel.HotelService.exception;


import com.learning.hotel.HotelService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage();
        ApiResponse apiResponse= ApiResponse.builder().message(message).status(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);

    }
}
