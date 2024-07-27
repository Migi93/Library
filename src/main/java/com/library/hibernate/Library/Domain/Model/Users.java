package com.library.hibernate.Library.Domain.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int userId;
    @Column(name = "NOMBRE", nullable = false)
    private String name;
    @Column(name = "APELLIDO1", nullable = false)
    private String surname1;
    @Column(name = "APELLIDO2")
    private String surname2;
    @Column(name = "DNI", nullable = false)
    private String dni;
    @Column(name = "TELEFONO_MOVIL", nullable = false)
    private String mobilePhone;
    @Column(name = "TELEFONO_FIJO")
    private String landline;
    @Column(name = "CORREO", nullable = false)
    private String email;
    @Column(name = "FECHA_CREACION")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date creationDate;
}
