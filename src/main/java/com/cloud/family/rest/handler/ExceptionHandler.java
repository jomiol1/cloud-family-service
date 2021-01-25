package com.cloud.family.rest.handler;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloud.family.constant.StatusCode;
import com.cloud.family.rest.dto.GenericResponse;
import com.cloud.family.rest.handler.exception.ItemNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {
	
	
   @ResponseStatus(
            value = HttpStatus.NOT_FOUND)
   @org.springframework.web.bind.annotation.ExceptionHandler(value = {ItemNotFoundException.class})
    public ResponseEntity<GenericResponse<Void>>
            notFoundExceptionHandler(HttpServletRequest request, Exception e) {
        final String message =
                (e instanceof ItemNotFoundException ) && e.getMessage() != null
                                ? e.getMessage()
                                : StatusCode.NOT_FOUND.getDescription();

        GenericResponse<Void> response = new GenericResponse<>();
        response.setMessage(message);
        response.setStatusCode(StatusCode.NOT_FOUND.getCode());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
   
   @ResponseStatus(
           value = HttpStatus.INTERNAL_SERVER_ERROR)
  @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
   public ResponseEntity<GenericResponse<Void>>
   genericExceptionHandler(HttpServletRequest request, Exception e) {
	   final String message =
               e.getMessage() == null ? StatusCode.INTERNAL_SERVER_ERROR.getDescription()
                       : e.getMessage();

       GenericResponse<Void> response = new GenericResponse<>();
       response.setMessage(message);
       response.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR.getCode());

       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
   }
 

}
