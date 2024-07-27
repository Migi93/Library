package com.library.hibernate.Library.Application.exceptions;

import org.springframework.http.HttpStatus;

public class RequiredMissingFieldException extends ApplicationException {
    private static final String EXTERNAL_MESSAGE = "The %s field cannot be empty or null.";

    public RequiredMissingFieldException(HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode);
    }

    public RequiredMissingFieldException(String mensaje, HttpStatus statusCode) {

        super(EXTERNAL_MESSAGE, statusCode, new String[]{mensaje});
    }
}
