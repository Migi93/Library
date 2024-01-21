package com.api.library.infrastructure.outputport;

import com.api.library.domain.entity.Books;
import com.api.library.domain.entity.Editorials;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BooksRepository {
    @Insert("INSERT INTO LIBROS (TITULO, EDITORIAL_ID, FECHA_PUBLICACION, ISBN) VALUES (#{title}, #{editorial.editorialId}, #{publicationDate, jdbcType=DATE}, "
            + "#{isbn})")
    @Options(useGeneratedKeys = true, keyProperty = "bookId", keyColumn = "ID")
    void insertBook(Books books);

    @Select("SELECT * FROM LIBROS l INNER JOIN EDITORIALES e ON l.EDITORIAL_ID = e.ID ORDER BY l.ID")
    @Result(property = "bookId", column = "ID")
    @Result(property = "title", column = "TITULO")
    @Result(property = "editorial.editorialId", column = "EDITORIAL_ID")
    @Result(property = "publicationDate", column = "FECHA_PUBLICACION")
    @Result(property = "isbn", column = "ISBN")
    @Result(property = "editorial.name", column = "NOMBRE")
    @Result(property = "editorial.address", column = "DIRECCION")
    @Result(property = "editorial.phone", column = "TELEFONO")
    @Result(property = "editorial.email", column = "CORREO")
    @Result(property = "editorial.creationDate", column = "FECHA_CREACION")
    List<Books> getBooks();

    @Select("SELECT * FROM LIBROS l INNER JOIN EDITORIALES e ON l.EDITORIAL_ID = e.ID WHERE l.ID = #{bookId}")
    @Result(property = "bookId", column = "ID")
    @Result(property = "title", column = "TITULO")
    @Result(property = "editorial.editorialId", column = "EDITORIAL_ID")
    @Result(property = "publicationDate", column = "FECHA_PUBLICACION")
    @Result(property = "isbn", column = "ISBN")
    @Result(property = "editorial.name", column = "NOMBRE")
    @Result(property = "editorial.address", column = "DIRECCION")
    @Result(property = "editorial.phone", column = "TELEFONO")
    @Result(property = "editorial.email", column = "CORREO")
    @Result(property = "editorial.creationDate", column = "FECHA_CREACION")
    Books getBook(int bookId);

    @Select("SELECT COUNT(ID) FROM LIBROS WHERE ID = #{bookId}")
    int existBook(int bookId);

    @Delete("DELETE FROM LIBROS WHERE ID = #{bookId}")
    void deleteBook(int bookId);

    @Select("SELECT COUNT(ISBN) FROM LIBROS WHERE ISBN = #{isbn}")
    int existIsbn(String isbn);

    @Update("UPDATE LIBROS SET TITULO = #{title}, EDITORIAL_ID = #{editorial.editorialId}, FECHA_PUBLICACION = #{publicationDate, jdbcType=DATE}, ISBN = #{isbn} " +
            "WHERE ID = #{bookId}")
    void updateBook(Books books);
}
