package com.rbm.carDealer.models;

import org.springframework.hateoas.RepresentationModel;

/**
 * Created by rakshabm on 2020-04-11
 **/

public class Car extends RepresentationModel<Car> {

    private int id;

    private String name;

    private String manufacturerName;

    private String model;

    private String manufacturingYear;

    private String color;

    public String getManufacturerName()
    {
        return manufacturerName;
    }

    public void setManufacturerName( String manufacturerName )
    {
        this.manufacturerName = manufacturerName;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel( String model )
    {
        this.model = model;
    }

    public String getManufacturingYear()
    {
        return manufacturingYear;
    }

    public void setManufacturingYear( String manufacturingYear )
    {
        this.manufacturingYear = manufacturingYear;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor( String color )
    {
        this.color = color;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }


}
