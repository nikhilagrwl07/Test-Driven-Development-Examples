package com.pratice.tdd.car.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;

    public Car() {
    }

    @JsonCreator
    public Car(@JsonProperty("name") String name,
               @JsonProperty("type") String type) {
        Assert.notNull(name, "name must not be null");
        Assert.notNull(type, "type must not be null");

        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
