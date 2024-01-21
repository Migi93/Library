package com.api.library.infrastructure.inputadapter;

import com.api.library.application.exceptions.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String DESCRIPTION = "Description: ";

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleApplicationException(ApplicationException e) {
        return new ResponseEntity<>(Map.of(DESCRIPTION, e.getExternalMessage()), e.getStatusCode());
    }

    /*@ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(Exception e) {
        return new ResponseEntity<>(Map.of(DESCRIPTION, "Error: An error has occurred. Contact the IT department of the Library."), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
