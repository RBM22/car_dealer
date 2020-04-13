package com.rbm.carDealer.controller;

import com.rbm.carDealer.models.Car;
import com.rbm.carDealer.models.ServiceResponse;
import com.rbm.carDealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakshabm on 2020-04-11
 **/
@RestController public class CarController {

    @Autowired private CarService carService;

    @GetMapping( value = "/car/all", produces = MediaTypes.HAL_JSON_VALUE ) public List<Car> getCars()
    {
        return carService.getAllCars();
    }

    @GetMapping( "/car/{id}" ) public Car getCar( @PathVariable Integer id ) throws Exception
    {
        return carService.getCarInfoById(id);
    }

    @PutMapping( "/car/{id}/update" ) public Car getUpdateCarInfo( @PathVariable Integer id, @RequestBody Car car )
            throws Exception
    {
        return carService.update(id, car);
    }

    @DeleteMapping( "/car/{id}/delete" ) public ServiceResponse deleteCar( @PathVariable Integer id ) throws Exception
    {
        return new ServiceResponse("SUCCESS", carService.deleteCar(id));
    }


    @PostMapping("/car/add")
    public ServiceResponse insertCar(@RequestParam() String name,@RequestParam() String manufacturerName,@RequestParam() String model,@RequestParam() String manufacturingYear,@RequestParam() String color ){
        return carService.insertCar(name, manufacturerName, model, manufacturingYear, color);
    }

    @GetMapping( "/car/searchBy" ) public List<Car> getCar(@RequestParam(required = false) String name,@RequestParam(required = false) String manufacturerName,@RequestParam(required = false) String model,@RequestParam(required = false) String manufacturingYear,@RequestParam(required = false) String color  ) throws Exception
    {
        return carService.searchCars(name, manufacturerName, model, manufacturingYear, color);
    }

}
