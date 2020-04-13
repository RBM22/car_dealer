package com.rbm.carDealer.config;

import com.rbm.carDealer.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rakshabm on 2020-04-12
 **/
public class MyUserDetails implements UserDetails {

    private String username;
    private String password;

    public MyUserDetails(String username)
    {
        this.username = username;
    }

    public MyUserDetails()
    {
    }

    public MyUserDetails( User user)
    {
        this.username = user.getEmailId();
        this.password = user.getPassword();
    }



    @Override public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override public String getPassword()
    {
        return password;
    }

    @Override public String getUsername()
    {
        return username;
    }

    @Override public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override public boolean isEnabled()
    {
        return true;
    }
}
