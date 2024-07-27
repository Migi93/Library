package com.library.hibernate.Library.Application;

import com.library.hibernate.Library.Application.Enum.Amount;
import com.library.hibernate.Library.Application.exceptions.ObjectAlreadyExistsException;
import com.library.hibernate.Library.Application.exceptions.ObjectNotFoundException;
import com.library.hibernate.Library.Application.utils.ValidationsUtils;
import com.library.hibernate.Library.Domain.Model.Users;
import com.library.hibernate.Library.Infraestructure.InputPort.UsersInputPort;


import com.library.hibernate.Library.Infraestructure.OutputPort.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UsersUserCase implements UsersInputPort{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    ValidationsUtils validationsUtils;

    @Override
    public Users getUser(String dni) {
        notExistUser(dni);
        return usersRepository.findByDni(dni);
    }

    @Override
    public List<Users> getUsers() {
        return (List<Users>) this.usersRepository.findAll();
    }

    @Override
    @Transactional
    public void createUser(Users users) {
        exitUser(users.getDni());
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
        usersRepository.save(users);
    }

    @Override
    @Transactional
    public void deleteUser(String dni) {
        this.usersRepository.deleteByDni(dni);
    }

    @Override
    public void updateUser(Users users) {
        notExistUser(users.getDni());
        this.usersRepository.save(users);
    }

    //VALIDACIONES
    private void notExistUser(String dni) {
        Optional<Users> optionalUsuario = Optional.ofNullable(usersRepository.findByDni(dni));
        if (optionalUsuario.isEmpty()) {
            throw new ObjectNotFoundException("user", HttpStatus.NOT_FOUND);
        }
    }

    private void exitUser(String dni){
        if (usersRepository.findByDni(dni) != null) {
            throw new ObjectAlreadyExistsException("user", HttpStatus.CONFLICT);
        }
    }

    //TODO:Hacer validaciones para los campos que deben ser unicos (CORREO), para que no salga el mensaje:
    //ORA-00001: restricción única (BIBLIOTECA.SYS_C007669) violada

}
