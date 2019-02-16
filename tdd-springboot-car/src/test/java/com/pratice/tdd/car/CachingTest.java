package com.pratice.tdd.car;

import com.pratice.tdd.car.domain.Car;
import com.pratice.tdd.car.respository.CarRespository;
import com.pratice.tdd.car.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    CarService carService;

    @MockBean
    CarRespository carRespository;

    @Test
    public void testing_cache(){
        given(carRespository.findCarByName(anyString())).willReturn(new Car("Honda", "Petrol"));

        carService.getCarDetails("honda");
        carService.getCarDetails("honda");

        verify(carRespository, times(1)).findCarByName("honda");
    }
}
