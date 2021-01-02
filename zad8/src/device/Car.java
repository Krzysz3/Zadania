package device;

import java.math.BigDecimal;
import com.company.Human;
import com.company.Sellable;

public class Car extends Device implements Sellable {
    private String model;
    private Double engine_size;
    private BigDecimal value;

    public Car() {
        this.model = "";
        this.engine_size = 0.0;
        this.value = new BigDecimal("0.0");
    }
    public Car(String model, String producer, Double engine_size, BigDecimal value) {
        super(producer,2000,false);
        this.model = model;
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
        return super.producer;
    }

    public void setProducer(String producer) {
        super.producer = producer;
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
                super.producer.equals(car.producer);
    }

    @Override
    public String toString() {
        return super.producer + " " +
                this.model + " with " +
                this.engine_size + " " +
                this.value.doubleValue() + " EUR.";
    }
    @Override
    public void turnOn() {
        super.mode = true;
    }

    @Override
    public void turnOff() {
        super.mode = false;
    }

    @Override
    public boolean sell(Human seller, Human buyer, BigDecimal price) {
        if (seller.getCar() == null)  {
            System.out.println("He doesn't have a car. It's scam.");
            return false;
        }
        if (buyer.getMoney() < price.doubleValue()) {
            System.out.println("He doesn't have money. It's a cheater.");
            return false;
        }

        buyer.addMoney(price.doubleValue() * -1);
        seller.addMoney(price.doubleValue());

        buyer.setCar(seller.getCar());
        seller.setCar(null);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");

        return true;
    }

}

