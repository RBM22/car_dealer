package com.rbm.carDealer.controller;

import com.rbm.carDealer.mappers.UserMapper;
import com.rbm.carDealer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rakshabm on 2020-04-12
 **/
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/all")
    public List<User> getUser(){
        return userMapper.findAll();
    }

}
