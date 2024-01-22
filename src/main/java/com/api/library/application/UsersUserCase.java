package com.api.library.application;

import com.api.library.application.Enum.Amount;
import com.api.library.application.exceptions.ObjectAlreadyExistsException;
import com.api.library.application.exceptions.ObjectNotFoundException;
import com.api.library.application.utils.ValidationsUtils;
import com.api.library.domain.model.Users;
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
    @Autowired
    ValidationsUtils validationsUtils;

    @Override
    public Users getUser(String dni) {
        notExistUser(dni);
        return usersRepository.getUser(dni);
    }

    @Override
    public List<Users> getUsers() {
        return usersRepository.getUsers();
    }

    @Override
    public void createUser(Users users) {
        existUser(users.getDni());
        validationsUtils.validateNotIsEmpty(users.getName(), "name");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), users.getName().length(), "name");
        validationsUtils.validateNotIsEmpty(users.getSurname1(), "surname1");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), users.getSurname1().length(), "surname1");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), users.getSurname2().length(), "surname2");
        validationsUtils.validateNotIsEmpty(users.getDni(), "dni");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_9.getValue(), users.getDni().length(), "dni");
        validationsUtils.validateNotIsEmpty(users.getMobilePhone(), "mobilePhone");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_15.getValue(), users.getMobilePhone().length(), "mobilePhone");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_15.getValue(), users.getLandline().length(), "landline");
        validationsUtils.validateNotIsEmpty(users.getEmail(), "email");
        validationsUtils.validateLengthAttribute(Amount.AMOUNT_50.getValue(), users.getEmail().length(), "email");
        usersRepository.createUser(users);
    }

    @Override
    public void deleteUser(String dni) {
        usersRepository.deleteUser(dni);
    }

    @Override
    public void updateUser(Users users) {
        notExistUser(users.getDni());
        usersRepository.updateUser(users);
    }

    private void notExistUser(String dni) {
        if (usersRepository.exitUser(dni) < 1) {
            throw new ObjectNotFoundException("user", HttpStatus.NOT_FOUND);
        }
    }

    private void existUser(String dni) {
        if (usersRepository.exitUser(dni) > 0) {
            throw new ObjectAlreadyExistsException("user", HttpStatus.CONFLICT);
        }
    }
}
