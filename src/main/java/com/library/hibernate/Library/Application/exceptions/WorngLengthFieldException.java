package com.library.hibernate.Library.Application.exceptions;

import org.springframework.http.HttpStatus;

public class WorngLengthFieldException extends ApplicationException {

    private static final String EXTERNAL_MESSAGE = "The %s field exceeds the maximum input length.";

    public WorngLengthFieldException() {
        super(EXTERNAL_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    public WorngLengthFieldException(String variable, HttpStatus statusCode) {
        super(EXTERNAL_MESSAGE, statusCode, new String[]{variable});
    }

}
