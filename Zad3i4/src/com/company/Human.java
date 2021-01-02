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
        this.car = car;
    }
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) throws IllegalArgumentException {
        if (salary < 0)
            throw new IllegalArgumentException("Wynagrodzenie nie moze byc mniejsze niz 0");
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
}