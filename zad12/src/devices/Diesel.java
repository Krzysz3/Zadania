package devices;

import java.math.BigDecimal;

public class Diesel extends Car {
    public Diesel() {
    }

    public Diesel(String model, String producer, Double engine_size, BigDecimal value, int year) {
        super(model, producer, engine_size, value, year);
    }

    @Override
    public void refuel() {
        System.out.println("Tanking oil..");
    }

    @Override
    public String toString() {
        return "Diesel car: " + super.toString();
    }
}
