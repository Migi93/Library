package com.api.library.infrastructure.outputport;

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
public interface EditorialsRepository {
    @Select("SELECT * FROM EDITORIALES WHERE ID=#{editorialId}")
    @Result(property = "editorialId", column = "ID")
    @Result(property = "name", column = "NOMBRE")
    @Result(property = "address", column = "DIRECCION")
    @Result(property = "phone", column = "TELEFONO")
    @Result(property = "email", column = "CORREO")
    @Result(property = "creationDate", column = "FECHA_CREACION")
    Editorials getEditorial(int editorialsId);

    @Select("SELECT COUNT(*) FROM EDITORIALES WHERE NOMBRE=#{nombre}")
    int existEditorial(String nameEditorial);

    @Select("SELECT COUNT(ID) FROM EDITORIALES WHERE ID=#{editorialId}")
    int notExistEditorial(int editorialId);

    @Select("SELECT * FROM EDITORIALES")
    @Result(property = "editorialId", column = "ID")
    @Result(property = "name", column = "NOMBRE")
    @Result(property = "address", column = "DIRECCION")
    @Result(property = "phone", column = "TELEFONO")
    @Result(property = "email", column = "CORREO")
    @Result(property = "creationDate", column = "FECHA_CREACION")
    List<Editorials> getEditorials();

    @Insert("INSERT INTO EDITORIALES (NOMBRE, DIRECCION, TELEFONO, CORREO, FECHA_CREACION) VALUES (#{name}, #{address}, #{phone}, #{email}, " +
            "SYSDATE)")
    @Options(useGeneratedKeys = true, keyProperty = "editorialId", keyColumn = "ID")
    void createEditorial(Editorials editorials);

    @Update("UPDATE EDITORIALES SET NOMBRE = #{name}, DIRECCION = #{address}, TELEFONO = #{phone}, CORREO = #{email}, FECHA_CREACION = #{creationDate , jdbcType=DATE} " +
            "WHERE ID = #{editorialId}")
    void updateEditorial(Editorials editorials);

    @Delete("DELETE FROM EDITORIALES WHERE ID = #{editorialId}")
    void deleteEditorial(int editorialId);


}
