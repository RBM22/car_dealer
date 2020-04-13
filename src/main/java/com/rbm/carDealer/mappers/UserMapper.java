package com.rbm.carDealer.mappers;

import com.rbm.carDealer.models.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * Created by rakshabm on 2020-04-11
 **/
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where emailId=#{emailId}") Optional<User> findByUserName(String emailId);

}
