package com.api.library.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import java.util.Date;


@Getter
@Setter
public class Users {

    private int userId;
    private String name;
    private String surname1;
    private String surname2;
    private String dni;
    private String mobilePhone;
    private String landline;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date creationDate;
}
