package com.rbm.carDealer.models;

/**
 * Created by rakshabm on 2020-04-11
 **/
public class User {

    private int id;

    private String emailId;

    private String password;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId( String emailId )
    {
        this.emailId = emailId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }
}
