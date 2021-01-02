package com.company;

public class Car {

    private String model;
    private String producer;
    private Double engine_size;

    public Car(String model, String producer, Double engine_size) {
        this.model = model;
        this.producer = producer;
        this.engine_size = engine_size;
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
}
