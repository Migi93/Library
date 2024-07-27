package com.library.hibernate.Library.Infraestructure.InputPort;

import com.library.hibernate.Library.Domain.Model.Users;

import java.util.List;

public interface UsersInputPort  {
    Users getUser(String dni);

    List<Users> getUsers();

    void createUser(Users users);

    void deleteUser(String dni);

    void updateUser(Users users);

}
