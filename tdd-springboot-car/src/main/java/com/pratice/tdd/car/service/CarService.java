package com.pratice.tdd.car.service;

import com.pratice.tdd.car.domain.Car;
import com.pratice.tdd.car.exception.CarNotFoundException;
import com.pratice.tdd.car.respository.CarRespository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRespository carRespository;

    public CarService(CarRespository carRespository) {
        this.carRespository=carRespository;
    }

    @Cacheable("cars")
    public Car getCarDetails(String carName) {

        Car car = carRespository.findCarByName(carName);

        if(car==null)
            throw new CarNotFoundException();

        return car;
    }
}
