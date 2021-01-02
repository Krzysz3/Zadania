package devices;

public abstract class Device {

    public Device(String producer, Integer year_of_production, boolean mode) {
        this.producer = producer;
        this.year_of_production = year_of_production;
        this.mode = mode;
    }

    public Device() {
        this.producer = "Nieznany";
        this.year_of_production = 2000;
        this.mode = false;
    }

    protected String producer;
    protected Integer year_of_production;
    protected boolean mode;

    public abstract void turnOn();
    public abstract void turnOff();

    public boolean currentMode() {
        return mode;
    }

    @Override
    public String toString() {
        return "Wyprodukowany przez " + producer + " w " +
                year_of_production;
    }
}