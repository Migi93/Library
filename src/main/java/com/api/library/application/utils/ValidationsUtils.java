package com.api.library.application.utils;

import com.api.library.application.exceptions.RequiredMissingFieldException;
import com.api.library.application.exceptions.WorngLengthFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidationsUtils {
    public void validateLengthAttribute(int amount, int length, String name) {
        if (length > amount) {
            throw new WorngLengthFieldException(name, HttpStatus.PAYLOAD_TOO_LARGE);
        }
    }

    public void validateNotIsEmpty(String field, String name) {
        if (field.isEmpty()) {
            throw new RequiredMissingFieldException(name, HttpStatus.BAD_REQUEST);
        }
    }
}
