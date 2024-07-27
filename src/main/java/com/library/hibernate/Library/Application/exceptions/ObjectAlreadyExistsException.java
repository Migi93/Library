package com.library.hibernate.Library.Application.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectAlreadyExistsException extends ApplicationException {

    private static final String EXTERNAL_MESSAGE = "The %s already exists.";

    public ObjectAlreadyExistsException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public ObjectAlreadyExistsException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}