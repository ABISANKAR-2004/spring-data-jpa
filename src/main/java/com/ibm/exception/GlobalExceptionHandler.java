package com.ibm.exception;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        ErrorMessage error = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
    		MethodArgumentNotValidException ex, HttpServletRequest request)
    	{
    		// Field-wise error messages
    		Map<String, String> errorsMap = new HashMap<String, String>();
    		ex.getBindingResult().getFieldErrors().forEach(error ->{
    			errorsMap.put(error.getField(), error.getDefaultMessage()); 
    		});
    		// final response Structure
    		
    		Map<String,Object> response = new HashMap<>();
    		response.put("timeStamp", LocalTime.now());
    		response.put("status", 400);
    		response.put("message", "Validation Failed");
    		response.put("error", errorsMap);
    		response.put("path", request.getRequestURI());
    		
    	  return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}