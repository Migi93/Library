package com.api.library.application;

import com.api.library.application.exceptions.NotFoundException;
import com.api.library.domain.entity.Users;
import com.api.library.infrastructure.inputport.UsersInputPort;
import com.api.library.infrastructure.outputport.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersUserCase implements UsersInputPort {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users getUser(String dni) {
        existUser(dni);
        return usersRepository.getUser(dni);
    }

    @Override
    public List<Users> getUsers() {
        return usersRepository.getUsers();
    }

    @Override
    public void createUser(Users users) {
        existUser(users.getDni());
        usersRepository.createUser(users);
    }

    @Override
    public void deleteUser(String dni) {
        usersRepository.deleteUser(dni);
    }

    @Override
    public void updateUser(Users users) {
        existUser(users.getDni());
        usersRepository.updateUser(users);
    }

    private void existUser(String dni) {
        if (usersRepository.exitUser(dni) < 1) {
            throw new NotFoundException("user", HttpStatus.NOT_FOUND);
        }
    }
}
