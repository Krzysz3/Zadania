package devices;
import com.company.Human;
import com.company.Sellable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public abstract class Car extends Device implements Sellable, Comparable<Car>, Comparator<Car> {

    private BigDecimal value;
    private String model;
    private Double engine_size;
    public BigDecimal fuel_state; // 0 - 100

    private List<Human> owners;
    private List<Transaction> transactions;

    public Car() {
        this.model = "";
        this.engine_size = 0.0;
        this.value = new BigDecimal("1.0");
        this.fuel_state = new BigDecimal(1.0);

        this.owners = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }


    public Car(String model, String producer, Double engine_size, BigDecimal value, int year) {
        super(producer, 2000, false);
        this.model = model;
        this.engine_size = engine_size;
        this.value = value;
        this.fuel_state = new BigDecimal(1.0);
        this.year_of_production = year;

        this.owners = new ArrayList<>();
        this.transactions = new ArrayList<>();
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
    public boolean sell(Human seller, int index, Human buyer, BigDecimal price) {
        if (seller.getCar(index) == null) {
            throw new IllegalStateException("He doesn't have a car. It's scam.");
        }

        if (this.getCurrentOwner() != seller) {
            throw new IllegalStateException("He is not current owner of a car.");
        }

        if (buyer.getMoney() < price.doubleValue()) {
            throw new IllegalArgumentException("He doesn't have money. It's a cheater.");
        }
        if (buyer.howManyCarsInGarage() == buyer.getGarageSize()) {
            throw new IllegalStateException("Buyer doesnt have free space in garage.");
        }
        buyer.setCar(seller.getCar(index));
        seller.deleteCar(index);
        seller.addMoney(price.doubleValue());
        buyer.addMoney(price.doubleValue() * -1);

        this.owners.add(buyer);

        this.transactions.add(new Transaction(seller, buyer, price, new Date()));

        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");

        return true;
    }
    @Override
    public boolean sell(Human seller, Human buyer, BigDecimal price) {
        return false;
    }
    @Override
    public int compareTo(Car o) {
        System.out.println(this.toString());
        System.out.println(o.toString());
        if (o == null) return this.year_of_production;
        return this.year_of_production - o.year_of_production;
    }
    @Override
    public int compare(Car o1, Car o2) {
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        if (o1 == null && o2 != null) return o2.year_of_production;
        if (o2 == null && o1 != null) return o1.year_of_production;
        if (o1 == null && o2 == null) return 0;
        return o1.year_of_production - o2.year_of_production;
    }
    public int getYear() {
        return this.year_of_production;
    }

    public List<Human> getOwners() {
        return owners;
    }

    public void setOwners(List<Human> owners) {
        this.owners = owners;
    }

    public Human getCurrentOwner() {
        return this.owners.get(this.owners.size()-1);
    }

    public void addNewOwner(Human new_owner) {
        // is instance of if (new_owner)
        this.owners.add(new_owner);
    }

    public boolean checkIfHumanWasPreviouslyOwner(Human previous_owner) {
        return this.owners.contains(previous_owner);
    }

    public boolean checkIfHumanASoldCarToHumanB(Human a, Human b) throws IllegalArgumentException {
        if (this.owners.contains(a) && this.owners.contains(b))
            return this.owners.indexOf(b) - this.owners.indexOf(a) == 1;

        throw new IllegalArgumentException("Jakis czlowiek nie byl wlascicielem.");
    }


    public int getHowManyTransactionsWereMadeOnThisCar() {
        return this.transactions.size();
    }
    public abstract void refuel();
}

