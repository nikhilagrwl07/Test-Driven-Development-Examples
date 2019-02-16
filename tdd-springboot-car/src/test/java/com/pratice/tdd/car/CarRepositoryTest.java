package com.pratice.tdd.car;

import com.pratice.tdd.car.domain.Car;
import com.pratice.tdd.car.respository.CarRespository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRespository carRespository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void getCar_returnCarDetails() {
        Car savedCar = testEntityManager.persistFlushFind(new Car("honda", "petrol"));
        Car car = carRespository.findCarByName("honda");

        Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
        Assertions.assertThat(car.getType()).isEqualTo(savedCar.getType());
    }
}
