package com.api.library.application.exceptions;

import org.springframework.http.HttpStatus;

public class EditorialNotFoundexception extends ApplicationException {
    private static final String EXTERNAL_MESSAGE = "%s not found.";

    public EditorialNotFoundexception() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public EditorialNotFoundexception(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}
