package com.library.hibernate.Library.Infraestructure.Adapter;

import com.library.hibernate.Library.Domain.Model.Users;
import com.library.hibernate.Library.Infraestructure.InputPort.UsersInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersAPI {
    @Autowired
    UsersInputPort usersInputPort;

    @GetMapping("/{dni}")
    @ResponseStatus(HttpStatus.OK)
    public Users getUser(@PathVariable("dni") String dni) {
        return this.usersInputPort.getUser(dni);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getUsers() {
        return this.usersInputPort.getUsers();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Integer> createUser(@RequestBody Users users) {
        this.usersInputPort.createUser(users);
        return Map.of("id", users.getUserId());
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody Users users) {
        usersInputPort.updateUser(users);
    }

    @DeleteMapping("/{dni}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("dni") String dni) {
        this.usersInputPort.deleteUser(dni);
    }
}
