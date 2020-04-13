package com.rbm.carDealer.models;

/**
 * Created by rakshabm on 2020-04-13
 **/
public class ServiceResponse {

    private String status;

    private String message;

    public String getStatus()
    {
        return status;
    }

    public void setStatus( String status )
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public ServiceResponse( String status, String message )
    {
        this.status = status;
        this.message = message;
    }
}
