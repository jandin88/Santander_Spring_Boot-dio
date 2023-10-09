package com.santander_spring_boot_dio.service.impl;

import com.santander_spring_boot_dio.domain.model.Users;
import com.santander_spring_boot_dio.domain.repository.UserRepository;
import com.santander_spring_boot_dio.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Users creatUser(Users newUSer) {
        if(userRepository.existsByAccountNumber(newUSer.getAccount().getNumber())){
            throw new IllegalArgumentException("this User Account exists");
        }
        return userRepository.save(newUSer);
    }
}
