package com.api.library.application.exceptions;

import org.springframework.http.HttpStatus;

public class AtributteNotIsUniqueException extends ApplicationException {

    private static final String EXTERNAL_MESSAGE = "The field %s already exists.";

    public AtributteNotIsUniqueException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public AtributteNotIsUniqueException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}
