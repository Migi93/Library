package com.api.library.application.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationException {

    private static final String EXTERNAL_MESSAGE = "Error. The %s does not exist.";

    public NotFoundException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public NotFoundException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}
