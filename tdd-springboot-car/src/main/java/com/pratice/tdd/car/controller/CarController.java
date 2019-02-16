package com.pratice.tdd.car.controller;

import com.pratice.tdd.car.domain.Car;
import com.pratice.tdd.car.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {


    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{name}")
    private Car getCar(@PathVariable String name){
        return carService.getCarDetails(name);
    }
}
