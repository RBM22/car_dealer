package com.rbm.carDealer.config;

import com.rbm.carDealer.models.User;
import com.rbm.carDealer.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by rakshabm on 2020-04-12
 **/
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired UserMapper userMapper;

    @Override public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
        Optional<User> user = userMapper.findByUserName(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found: " + username));
        return user.map(MyUserDetails::new).get();
    }
}
