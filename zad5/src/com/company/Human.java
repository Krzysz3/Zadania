package com.company;

public class Human {
    private String name;
    private String surname;
    private Double age;
    private Phone number;
    private Animal pet;
    private Car car;
    private Double salary;

    public Human() {
    }

    public Human(String name, String surname, Double age, Phone number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
    }

    public Human(String name, String surname, Double age, Phone number, Animal pet) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
    }

    public Human(String name, String surname, Double age, Phone number, Animal pet, Car car) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.pet = pet;
        this.car = car;
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
        if (this.salary.isNaN())
            throw new IllegalStateException("Dude, you have no job.");

        if (this.salary < (car.getValue().doubleValue() / 12)) {
            System.out.println("Go study, get new job(better payment) or go for a raise(big raise).");
            return;
        }
        if (this.salary > car.getValue().doubleValue()) {
            System.out.println("Congratulations, you bought " + car.getModel());
        } else if (this.salary > (car.getValue().doubleValue() / 12)) {
            System.out.println("Woah, big fella. You got " + car.getModel() + ", but you have bought it on credit.");
        }

        this.car = car;
    }

    public Double getSalary() {
        if (!this.salary.isNaN()) return salary;

        return 0.0;
    }

    public void setSalary(Double salary) throws IllegalArgumentException {
        if (salary < 0)
            throw new IllegalArgumentException("Wynagrodzenie nie moze byc nizsze niz 0");
        this.salary = salary;
        System.out.println("Nowe wynagrodzenie zostalo wyslane na konto.");
        System.out.println("Idz do HR podpisac umowe.");
        System.out.println("Rządz wie wszystko.");
    }


    public void raiseSalary(Double raise) throws IllegalArgumentException, IllegalAccessException {
        if (raise < 0)
            throw new IllegalArgumentException("Podwyzka nie moze byc nizsza niz 0");
        if (!(this.salary > 0))
            throw new IllegalAccessException("Nie dostaniesz podwyzki nie majac pray.");

        this.salary = this.salary + raise;
    }
}

