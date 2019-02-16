package com.pratice.tdd.car;

import com.pratice.tdd.car.domain.Car;
import com.pratice.tdd.car.exception.CarNotFoundException;
import com.pratice.tdd.car.respository.CarRespository;
import com.pratice.tdd.car.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    private CarService carService;

    @Mock
    private CarRespository carRespository;

    @Before
    public void setUp() {
        carService = new CarService(carRespository);
    }

    @Test
    public void getCar_returnCarByName(){
        given(carRespository.findCarByName(anyString())).willReturn(new Car("honda","petrol"));

        Car car = carService.getCarDetails("honda");

        assertThat(car.getName()).isEqualTo("honda");
        assertThat(car.getType()).isEqualTo("petrol");

    }

    @Test(expected = CarNotFoundException.class)
    public void getNotFound_returnCarByName(){
        given(carRespository.findCarByName(anyString())).willReturn(null);

        carService.getCarDetails("honda");
    }
}
