package com.library.hibernate.Library.Application.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends ApplicationException {
    private static final String EXTERNAL_MESSAGE = "%s not found.";

    public ObjectNotFoundException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public ObjectNotFoundException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}
