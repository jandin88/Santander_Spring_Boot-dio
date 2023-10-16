package com.santander_spring_boot_dio.service;

import com.santander_spring_boot_dio.domain.model.Users;

import java.util.List;

public interface UserService {

    Users findById(Long id);

    Users creatUser(Users newUSer);

    Users findByName(String name);
    List <Users> findByAll();

}
