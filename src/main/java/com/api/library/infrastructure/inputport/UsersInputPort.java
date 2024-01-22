package com.api.library.infrastructure.inputport;

import com.api.library.domain.model.Users;

import java.util.List;

public interface UsersInputPort {
    Users getUser(String dni);

    List<Users> getUsers();

    void createUser(Users users);

    void deleteUser(String dni);

    void updateUser(Users users);
}
