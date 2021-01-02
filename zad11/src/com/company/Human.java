package com.company;

import devices.Application;
import devices.Car;
import devices.ORDER;
import devices.Phone;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Human implements Comparator<Human>, Comparable<Human> {
    private int GARAGE_SIZE;
    private String name;
    private String surname;
    private Double age;
    private Phone number;
    private Animal pet;
    private Car[] garage;
    private Double salary;
    private Double cash;
    /**
     * Default constructor.
     */
    public Human() {
        this.name = "";
        this.surname = "";
        this.age = 0.0;
        this.number = new Phone();
        this.pet = new Pet();
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
    }
    /**
     * Constructor of Human with basic parameters
     * @param name name of human
     * @param surname last name of human
     * @param age current age of human
     * @param number phone number of human
     */
    public Human(String name, String surname, Double age, Phone number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = new Pet();
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
    }
    /**
     * Constructor of Human with all parameters
     * @param name name of human
     * @param surname last name of human
     * @param age current age of human
     * @param number phone number of human
     * @param pet animal object that represents pet
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
    }
    /**
     * Constructor of Human with all parameters
     * @param name name of human
     * @param surname last name of human
     * @param age current age of human
     * @param number phone number of human
     * @param pet animal object that represents pet
     * @param car car object that represents car
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.salary = 0.0;
        this.cash = 0.0;
        this.GARAGE_SIZE = 5;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
        this.garage[0] = car;
        car.addNewOwner(this);
    }

    /**
     * Constructor that contains another important parameter, the size of a garage.
     * @param name  the name of a human
     * @param surname   the surname of a human
     * @param age   the age of a human
     * @param number    the phone number of a human
     * @param pet   the pet of a human (if exists) can be set as null tbh
     * @param GARAGE_SIZE   the size of a garage of human
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, int GARAGE_SIZE) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.cash = 0.0;
        this.GARAGE_SIZE = GARAGE_SIZE;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
    }
    /**
     * Constructor that contains another important parameter, the size of a garage.
     * @param name  the name of a human
     * @param surname   the surname of a human
     * @param age   the age of a human
     * @param number    the phone number of a human
     * @param pet   the pet of a human (if exists) can be set as null tbh
     * @param GARAGE_SIZE   the size of a garage of human
     * @param car   the car of a human that has to be set in garage
     */
    public Human(String name, String surname, Double age, Phone number, Animal pet, int GARAGE_SIZE, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.cash = 0.0;
        this.GARAGE_SIZE = GARAGE_SIZE;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }
        this.garage[0] = car;
        car.addNewOwner(this);
    }

    public Human(String name, String surname, Double age, Phone number, Animal pet, int GARAGE_SIZE, Car[] car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.cash = 0.0;
        this.GARAGE_SIZE = GARAGE_SIZE;
        this.garage = new Car[GARAGE_SIZE];
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            this.garage[index] = null;
        }

        for (int index = 0; index < car.length; ++index) {
            this.garage[index] = car[index];
            car[index].addNewOwner(this);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Double getAge() {
        return age;
    }
    public void setAge(Double age) {
        this.age = age;
    }
    public Phone getNumber() {
        return number;
    }
    public void setNumber(Phone number) {
        this.number = number;
    }
    public Animal getPet() {
        return pet;
    }
    public void setPet(Animal pet) {
        this.pet = pet;
    }
    public Car[] getCarsFromGarage() {
        return this.garage;
    }
    public Car getCar(int garage_position) {
        return this.garage[garage_position];
    }
    public void setCar(Car car) {
        if (this.salary.isNaN())
            throw new IllegalStateException("Stary nie masz roboty.");
        if (this.salary < (car.getValue().doubleValue()/12))
            throw new IllegalStateException("Idz na studia znajdz lepiej platna prace.");
        // if garage is not empty (no place for car then say it)
        if (this.garage[GARAGE_SIZE-1] != null)
            throw new IllegalStateException("Nie ma miejsca w garazu.");
        //
        if (this.salary > (car.getValue().doubleValue()/12))
            System.out.println("wau ale duzy masz " + car.getModel() + ", ale kupiles go na kredyt.");
        else
            System.out.println("Gratuluje kupies to  " + car.getModel());
        // check which place in garage is empty, cause we don't want to
        // overwrite a car in garage, and if empty place then set car
        for (int index = 0; index < GARAGE_SIZE; ++index) {
            if (this.garage[index] == null) {
                this.garage[index] = car;
                car.addNewOwner(this);
                break;
            }
        }
    }
    public void setCar(Car car, int index) {
        if (this.salary.isNaN())
            throw new IllegalStateException("Stary nie masz roboty.");
        if (this.salary < (car.getValue().doubleValue()/12)) {
            System.out.println("Idz na studia znajdz lepiej platna prace.");
            return;
        }
        // if garage is not empty (no place for car then say it)
        if (this.garage[index] != null) {
            System.out.println("Aktualnie masz tu w tym miejscu auto.");
            return;
        }
        if (this.salary > car.getValue().doubleValue()) {
            System.out.println("Gratuluje, kupiles go" + car.getModel());
        } else if (this.salary > (car.getValue().doubleValue()/12)) {
            System.out.println("wau ale duzy masz " + car.getModel() + ", ale kupiles go na kredyt.");
        }

        this.garage[index] = car;
        car.addNewOwner(this);
    }

    public void deleteCar(int index) {
        this.garage[index] = null;
    }
    public int getGarageSize() {
        return this.GARAGE_SIZE;
    }
    public int howManyCarsInGarage() throws IllegalArgumentException {
        int count_cars = 0;
        for (int index = 0; index < this.GARAGE_SIZE; ++index) {
            if (this.garage[index] != null) ++count_cars;
        }
        // basically it is not possible, but let's make sure everything will be ok when returning
        if (count_cars > this.GARAGE_SIZE)
            throw new IllegalArgumentException("Nie mozesz miec wiecej aut niz miejsca w garazu");
        return count_cars;
    }
    public Double getSalary() {
        if (!this.salary.isNaN()) return salary;
        return 0.0;
    }
    public void setSalary(Double salary) throws IllegalArgumentException {
        if (salary < 0)
            throw new IllegalArgumentException("Wynagrodznie nie moze byc nizsze niz 0");
        // set new salary first, cause we can't send this data everywhere and
        // don't change it.
        // imagine the situation when you send this everywhere and system shutdown's
        // accidentally and you don't have changed salary yet but everyone thinks it happened.
        this.salary = salary;
        System.out.println("Nowe wynagrodzenie plynie do banki.");
        System.out.println("Idz do HR podpisac umowe.");
        System.out.println("Rzad widzi wszystko!.");
    }

    public void raiseSalary(Double raise) throws IllegalArgumentException, IllegalAccessException {
        if (raise < 0)
            throw new IllegalArgumentException("podwyzka nie moze byc nizsza niz 0");
        if (!(this.salary > 0))
            throw new IllegalAccessException("Nie mozesz dostac podwyzki bez pracy..");
        this.salary = this.salary + raise;
    }
    @Override
    public boolean equals(Object obj) {
        Human human = (Human) obj;
        return this.name.equals(human.name) &&
                this.surname.equals(human.surname) &&
                this.age.doubleValue() == human.age.doubleValue() &&
                this.salary.doubleValue() == human.salary.doubleValue() &&
                this.number.equals(human.number) &&
                this.garage.equals(human.garage);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " to " +
                this.age + " wiek i jego zwierz: " + this.pet +
                " jego numer to: " + this.number;
    }

    public void addMoney(Double money) {
        this.cash += money;
    }
    public Double getMoney() {
        return this.cash;
    }
    public void sortCarsInGarage(ORDER order) {
        if (this.howManyCarsInGarage() < 2) return;
        if (ORDER.ASCENDING == order) {
            for (int index = 0; index < this.howManyCarsInGarage(); ++index) {
                for (int jndex = index + 1; jndex < this.howManyCarsInGarage(); ++jndex) {
                    if (this.garage[index].getYear() > this.garage[jndex].getYear()) {
                        Car temp = this.garage[jndex];
                        this.garage[jndex] = this.garage[index];
                        this.garage[index] = temp;
                    }
                }
            }
        } else {
            for (int index = 0; index < this.howManyCarsInGarage(); ++index) {
                for (int jndex = index + 1; jndex < this.howManyCarsInGarage(); ++jndex) {
                    if (this.garage[index].getYear() < this.garage[jndex].getYear()) {
                        Car temp = this.garage[jndex];
                        this.garage[jndex] = this.garage[index];
                        this.garage[index] = temp;
                    }
                }
            }
        }

    }

    @Override
    public int compare(Human o1, Human o2) {
        if (o1 == null || o2 == null) throw new IllegalStateException("Human doesnt exist.");

        if (o1.age.equals(o2.age) && o1.name.equals(o2.name) &&
                o1.surname.equals(o2.surname) && o1.number.equals(o2.number) &&
                o1.garage.equals(o2.garage)) return 0;

        return 1;
    }
    @Override
    public int compareTo(Human o2) {
        if (o2 == null) throw new IllegalStateException("Human doesnt exist.");

        if (this.age.equals(o2.age) && this.name.equals(o2.name) &&
                this.surname.equals(o2.surname) && this.number.equals(o2.number) &&
                this.garage.equals(o2.garage)) return 0;

        return 1;
    }
}