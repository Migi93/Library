package com.api.library.infrastructure.inputadapter;

import com.api.library.domain.entity.Users;
import com.api.library.infrastructure.inputport.UsersInputPort;
import com.api.library.infrastructure.outputport.UsersRepository;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersAPI {
    @Autowired
    UsersInputPort usersInputPort;

    @GetMapping("/{dni}")
    public ResponseEntity<Users> getUser(@PathVariable("dni") String dni) {
        return new ResponseEntity<>(this.usersInputPort.getUser(dni), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Users>> getUsers() {
        return new ResponseEntity<>(this.usersInputPort.getUsers(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createUser(@RequestBody Users users) {
        this.usersInputPort.createUser(users);
        return new ResponseEntity<>(Map.of("id", users.getUserId()), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody Users users) {
        usersInputPort.updateUser(users);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("dni") String dni) {
        this.usersInputPort.deleteUser(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
