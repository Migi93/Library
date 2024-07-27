package com.library.hibernate.Library.Domain.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "LIBROS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int bookId;

    @Column(name = "TITULO", nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "EDITORIAL_ID", nullable = false)
    private Editorials editorial;
    @Column(name = "FECHA_PUBLICACION")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date publicationDate;
    @Column(name = "ISBN", nullable = false)
    private String isbn;
}
