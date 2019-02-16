package com.pratice.tdd.car;

import com.pratice.tdd.car.domain.Car;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class CarDetailJsonTests {

    @Autowired
    private JacksonTester<Car> json;

//    @Before
//    public void setup(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        JacksonTester.initFields(this, objectMapper);
//    }

    @Test
    public void serializeJsonTest() throws IOException {
        Car car = new Car("Honda", "Petrol");
        assertThat(this.json.write(car)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(car)).extractingJsonPathStringValue("@.type").isEqualTo("Petrol");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"name\":\"Honda\",\"type\":\"Petrol\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new Car("Honda", "Petrol"));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("Honda");
    }

}
