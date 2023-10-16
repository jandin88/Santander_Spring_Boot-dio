package com.santander_spring_boot_dio.service.impl;

import com.santander_spring_boot_dio.domain.model.Users;
import com.santander_spring_boot_dio.domain.repository.UserRepository;
import com.santander_spring_boot_dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Users findByName(String name) {
        Users searchName= userRepository.findByName(name);
        if (searchName!=null){
            return searchName;
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Users> findByAll() {
        return userRepository.findAll();
    }

    @Override
    public Users creatUser(Users newUSer) {
        if(userRepository.existsByAccountNumber(newUSer.getAccount().getNumber())){
            throw new IllegalArgumentException("this User Account exists");
        }
        return userRepository.save(newUSer);
    }


}
