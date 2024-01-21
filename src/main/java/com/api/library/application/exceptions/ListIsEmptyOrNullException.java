package com.api.library.application.exceptions;

import org.springframework.http.HttpStatus;

public class ListIsEmptyOrNullException extends ApplicationException {

    private static final String EXTERNAL_MESSAGE = "The list of %s is empty.";

    public ListIsEmptyOrNullException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public ListIsEmptyOrNullException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }
}
