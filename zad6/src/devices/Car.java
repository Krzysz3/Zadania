package devices;

import java.math.BigDecimal;

public class Car {

    private String model;
    private String producer;
    private Double engine_size;
    private BigDecimal value;

    public Car() {
        this.model = "";
        this.producer = "";
        this.engine_size = 0.0;
        this.value = new BigDecimal("0.0");
    }
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
    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        return this.value.equals(car.value) &&
                this.engine_size.equals(car.engine_size) &&
                this.model.equals(car.model) &&
                this.producer.equals(car.producer);
    }

    @Override
    public String toString() {
        return this.producer + " " +
                this.model + " with " +
                this.engine_size + " " +
                this.value.doubleValue() + " EUR.";
    }
}
