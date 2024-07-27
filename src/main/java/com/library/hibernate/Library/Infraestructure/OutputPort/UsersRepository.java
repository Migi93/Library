package com.library.hibernate.Library.Infraestructure.OutputPort;

import com.library.hibernate.Library.Domain.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

//    @Query("SELECT u FROM Users u WHERE u.dni = :dni")
//    Users findByDni(@Param("dni") String dni);
    Users findByDni(String dni);
    void deleteByDni(String dni);
}
