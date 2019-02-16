package com.pratice.tdd.car.respository;

import com.pratice.tdd.car.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRespository extends JpaRepository<Car, Long> {
     Car findCarByName(String carName);
}
