package com.rbm.carDealer.services;

import com.rbm.carDealer.controller.CarController;
import com.rbm.carDealer.mappers.CarMapper;
import com.rbm.carDealer.models.Car;
import com.rbm.carDealer.models.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * Created by rakshabm on 2020-04-12
 **/
@Service public class CarService {

    @Autowired private CarMapper carMapper;

    public List<Car> getAllCars()
    {
        List<Car> allCars = carMapper.findAll();

        for( Car car : allCars )
        {

            car.add(Arrays.asList(getCarUpdateLink(car.getId()), getCarDeleteLink(car.getId()), getCarInfoLink(car.getId()), getCarInsertLink(car.getId())));
        }
        return allCars;
    }

    public Car getCarInfoById( Integer id ) throws Exception
    {
        Optional<Car> car = carMapper.findById(id);
        if( car.isPresent() )
        {
            car.get().add(Arrays.asList(getCarUpdateLink(car.get().getId()), getCarDeleteLink(car.get().getId()), getCarInsertLink(car.get().getId())));
        }
        else
        {
            throw new Exception("Invalid ID");
        }

        return car.get();
    }

    public Link getCarInfoLink( Integer id )
    {
        return linkTo(CarController.class).slash("car").slash(id).withSelfRel();
    }

    public Link getCarUpdateLink( int id )
    {
        return linkTo(CarController.class).slash("car").slash(id).slash("update").withRel("Update");
    }

    public Link getCarDeleteLink( int id )
    {
        return linkTo(CarController.class).slash("car").slash(id).slash("delete").withRel("Delete");
    }

    public Link getCarInsertLink( int id )
    {
        return linkTo(CarController.class).slash("car").slash("add").withRel("Add new car");
    }

    public Car update( Integer id, Car requestCar ) throws Exception
    {
        Optional<Car> car = carMapper.findById(id);
        if( car.isPresent() )
        {
            requestCar.setId(id);
            carMapper.update(requestCar.getName(), requestCar.getManufacturerName(),requestCar.getModel(),requestCar.getManufacturingYear(), requestCar.getColor(), id);
            car = carMapper.findById(id);
            car.get().add(Arrays.asList(getCarDeleteLink(id), getCarInfoLink(car.get().getId())));
            return car.get();

        }
        else
        {
            throw new Exception("Invalid ID");
        }
    }

    public String deleteCar( Integer id ) throws Exception
    {
        Optional<Car> car = carMapper.findById(id);
        if( car.isPresent() )
        {
            carMapper.delete(car.get());

        }
        else
        {
            throw new Exception("Invalid ID");
        }
        return null;
    }

    public ServiceResponse insertCar( String name, String manufacturerName, String model, String manufacturingYear,
            String color )
    {
        Car car = new Car();
        car.setName(name);
        car.setManufacturerName(manufacturerName);
        car.setColor(color);
        car.setManufacturingYear(manufacturingYear);
        car.setModel(model);
        carMapper.insert(car);
        return new ServiceResponse("SUCCESS", "The car has been added to the database");

    }

    public List<Car> searchCars( String name, String manufacturerName, String model, String manufacturingYear, String color )
    {

        List<Car> carsFound = carMapper.findByDynamicFilter(name, manufacturerName,model,manufacturingYear,color);
        for( Car car : carsFound )
        {
            car.add(Arrays.asList(getCarDeleteLink(car.getId()), getCarInfoLink(car.getId()), getCarUpdateLink(car.getId())));
        }
        return carsFound;
    }
}
