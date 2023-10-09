package com.santander_spring_boot_dio.controller;

import com.santander_spring_boot_dio.domain.model.Users;
import com.santander_spring_boot_dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        var userCreated= service.creatUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(userCreated)
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }


}
