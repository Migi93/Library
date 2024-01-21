package com.api.library.application.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectFoundException extends ApplicationException {

    private static final String EXTERNAL_MESSAGE = "Error. The %s already exists.";

    public ObjectFoundException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public ObjectFoundException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}