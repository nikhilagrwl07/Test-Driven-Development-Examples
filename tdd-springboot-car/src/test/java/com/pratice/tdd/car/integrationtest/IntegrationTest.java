package com.pratice.tdd.car.integrationtest;


import com.pratice.tdd.car.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCat_returnCarDetails(){
        //arrange

        //act
        ResponseEntity<Car> carDetailsResponse = restTemplate.getForEntity("/car/{name}", Car.class, "honda");

        //assert
        assertThat(carDetailsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(carDetailsResponse.getBody().getName()).isEqualTo("honda");
        assertThat(carDetailsResponse.getBody().getType()).isEqualTo("petrol");


    }
}
