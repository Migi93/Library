package com.api.library.infrastructure.outputport;

import com.api.library.domain.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UsersRepository {
    @Select("SELECT * FROM USUARIOS u WHERE u.DNI = #{dni}")
    @Result(property = "userId", column = "ID")
    @Result(property = "name", column = "NOMBRE")
    @Result(property = "surname1", column = "APELLIDO1")
    @Result(property = "surname2", column = "APELLIDO2")
    @Result(property = "dni", column = "DNI")
    @Result(property = "mobilePhone", column = "TELEFONO_MOVIL")
    @Result(property = "landline", column = "TELEFONO_FIJO")
    @Result(property = "email", column = "CORREO")
    @Result(property = "creationDate", column = "FECHA_CREACION")
    Users getUser(String dni);

    @Select("SELECT * FROM USUARIOS")
    @Result(property = "userId", column = "ID")
    @Result(property = "name", column = "NOMBRE")
    @Result(property = "surname1", column = "APELLIDO1")
    @Result(property = "surname2", column = "APELLIDO2")
    @Result(property = "dni", column = "DNI")
    @Result(property = "mobilePhone", column = "TELEFONO_MOVIL")
    @Result(property = "landline", column = "TELEFONO_FIJO")
    @Result(property = "email", column = "CORREO")
    @Result(property = "creationDate", column = "FECHA_CREACION")
    List<Users> getUsers();

    @Insert("INSERT INTO USUARIOS (NOMBRE, APELLIDO1, APELLIDO2, DNI, TELEFONO_MOVIL, TELEFONO_FIJO, CORREO, FECHA_CREACION) VALUES (#{name}, #{surname1}, " +
            "#{surname2}, #{dni}, #{mobilePhone}, #{landline}, #{email}, #{creationDate, jdbcType=DATE})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "ID")
    void createUser(Users users);

    @Delete("DELETE FROM USUARIOS WHERE DNI = #{dni}")
    void deleteUser(String dni);

    @Update("UPDATE USUARIOS SET NOMBRE = #{name}, APELLIDO1 = #{surname1}, APELLIDO2 = #{surname2}, DNI = #{dni}, " +
            "TELEFONO_MOVIL= #{mobilePhone}, TELEFONO_FIJO = #{landline}, CORREO = #{email}, FECHA_CREACION = #{creationDate, jdbcType=DATE} WHERE ID = #{userId}")
    void updateUser(Users users);

    @Select("SELECT COUNT(ID) FROM USUARIOS WHERE DNI = #{dni}")
    public int exitUser(String dni);

}
