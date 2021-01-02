package devices;

import java.math.BigDecimal;

public class Electric extends Car {
    public Electric() {
    }

    public Electric(String model, String producer, Double engine_size, BigDecimal value, int year) {
        super(model, producer, engine_size, value, year);
    }

    @Override
    public void refuel() {
        System.out.println("Charging car.");
    }

    @Override
    public String toString() {
        return "Electric car: " + super.toString();
    }
}
