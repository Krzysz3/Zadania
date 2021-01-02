package devices;

import java.math.BigDecimal;

public class LPG extends Car {
    public LPG() {
    }

    public LPG(String model, String producer, Double engine_size, BigDecimal value, int year) {
        super(model, producer, engine_size, value, year);
    }

    @Override
    public void refuel() {
        System.out.println("Tanking LPG..");
    }

    @Override
    public String toString() {
        return "LPG car: " + super.toString();
    }
}
