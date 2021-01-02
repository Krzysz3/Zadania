package com.company;

import java.math.BigDecimal;

public class Car {

    private String model;
    private String producer;
    private Double engine_size;
    private BigDecimal value;

    public Car(String model, String producer, Double engine_size, BigDecimal value) {
        this.model = model;
        this.producer = producer;
        this.engine_size = engine_size;
        this.value = value;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Double getEngineSize() {
        return engine_size;
    }
    public void setEngineSize(Double engine_size) {
        this.engine_size = engine_size;
    }

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
