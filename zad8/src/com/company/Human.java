package com.company;

import device.Car;
import device.Phone;

public class Human {
    private String name;
    private String surname;
    private Double age;
    private Phone number;
    private Animal pet;
    private Car car;
    private Double salary;
    private Double cash;


    public Human() {
        this.name = "";
        this.surname = "";
        this.age = 0.0;
        this.number = new Phone();
        this.pet = new Animal();
        this.car = new Car();
        this.salary = 0.0;
        this.cash = 0.0;

    }

    public Human(String name, String surname, Double age, Phone number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = new Animal();
        this.car = new Car();
        this.salary = 0.0;
        this.cash = 0.0;

    }

    public Human(String name, String surname, Double age, Phone number, Animal pet) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.car = new Car();
        this.salary = 0.0;
        this.cash = 0.0;

    }

    public Human(String name, String surname, Double age, Phone number, Animal pet, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.car = car;
        this.salary = 0.0;
        this.cash = 0.0;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) throws IllegalArgumentException {
        if (salary < 0)
            throw new IllegalArgumentException("Wynagrodzenie nie moze byc mniejsze niz 0");

        // set new salary first, cause we can't send this data everywhere and
        // don't change it.
        // imagine the situation when you send this everywhere and system shutdown's
        // accidentally and you don't have changed salary yet but everyone thinks it happened.
        this.salary = salary;
        System.out.println("Nowa pensja zostala wyslalana do systemu ksiegowego.");
        System.out.println("Idz do HR po aneks umowy.");
        System.out.println("Nie oklamiesz rzadu");
    }

    public void raiseSalary(Double raise) throws IllegalArgumentException {
        if (raise < 0)
            throw new IllegalArgumentException("podwyzka nie moze byc mniejsze niz 0");

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
                this.pet.equals(human.pet) &&
                this.car.equals(human.car);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " is " +
                this.age + " old and has a pet: " + this.pet +
                " and his phone number is: " + this.number;
    }

    public void addMoney(Double money) {
        this.cash += money;
    }

    public Double getMoney() {
        return this.cash;
    }
}