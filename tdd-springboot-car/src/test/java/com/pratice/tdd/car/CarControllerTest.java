package com.pratice.tdd.car;

import com.pratice.tdd.car.controller.CarController;
import com.pratice.tdd.car.domain.Car;
import com.pratice.tdd.car.exception.CarNotFoundException;
import com.pratice.tdd.car.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Before
    public void setup(){
        given(carService.getCarDetails(anyString()))
                .willReturn(new Car("honda","petrol"));
    }

    @Test
    public void getCar_shouldReturnCarDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/honda"))
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("name").value("honda"))
                   .andExpect(jsonPath("type").value("petrol"));
    }

    @Test
    public void getCar_notFound() throws Exception{
        given(carService.getCarDetails(anyString())).willThrow(CarNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/car/honda"))
                .andExpect(status().isNotFound());

    }

}

