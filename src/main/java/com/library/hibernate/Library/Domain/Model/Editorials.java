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
@Table(name = "EDITORIALES")
public class Editorials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer editorialId;
    @Column(name = "NOMBRE", nullable = false)
    private String name;
    @Column(name = "DIRECCION", nullable = false)
    private String address;
    @Column(name = "TELEFONO", nullable = false)
    private String phone;
    @Column(name = "CORREO")
    private String email;
    @Column(name = "FECHA_CREACION")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date creationDate;
}
