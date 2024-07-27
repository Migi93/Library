package com.library.hibernate.Library.Application.utils;


import com.library.hibernate.Library.Application.exceptions.RequiredMissingFieldException;
import com.library.hibernate.Library.Application.exceptions.WorngLengthFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidationsUtils {
    public void validateLengthAttribute(int amount, int lengthAttribute, String nameAttribute) {
        if (lengthAttribute > amount) {
            throw new WorngLengthFieldException(nameAttribute, HttpStatus.PAYLOAD_TOO_LARGE);
        }
    }

    public void validateNotIsEmpty(String field, String nameAttribute) {
        if (field.isEmpty()) {
            throw new RequiredMissingFieldException(nameAttribute, HttpStatus.BAD_REQUEST);
        }
    }
}
