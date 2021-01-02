package com.company;

import devices.Application;
import devices.Car;
import devices.ORDER;
import devices.Phone;

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
        throw new IllegalStateException("Nie masz pracy.");
    if (this.salary < (car.getValue().doubleValue()/12))
        throw new IllegalStateException("idz na studia zdobadz lepsza prace i lepiej platna.");
    // if garage is not empty (no place for car then say it)
    if (this.garage[GARAGE_SIZE-1] != null)
        throw new IllegalStateException("nie ma miejsca w garazu.");
    //
    if (this.salary > (car.getValue().doubleValue()/12))
        System.out.println("Wow, duzo masz " + car.getModel() + ", ale kuples na kredyty.");
    else
        System.out.println("Gratulacje! Kupiles " + car.getModel());
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
        throw new IllegalStateException("stary nie masz pracy.");
    if (this.salary < (car.getValue().doubleValue()/12)) {
        System.out.println("idz na studia zdobadz lepsza prace i lepiej platna.");
        return;
    }
    // if garage is not empty (no place for car then say it)
    if (this.garage[index] != null) {
        System.out.println("Aktualnie w tym miejscu masz auto.");
        return;
    }
    if (this.salary > car.getValue().doubleValue()) {
        System.out.println("Gratulacje! Kupiles " + car.getModel());
    } else if (this.salary > (car.getValue().doubleValue()/12)) {
        System.out.println("Wow, duzo masz " + car.getModel() + ", ale kuples na kredyty.");
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
        throw new IllegalArgumentException("You cant have more cars than places in garage");
    return count_cars;
}
public Double getSalary() {
    if (!this.salary.isNaN()) return salary;
    return 0.0;
}
public void setSalary(Double salary) throws IllegalArgumentException {
    if (salary < 0)
        throw new IllegalArgumentException("Salary can't be smaller than 0");
    this.salary = salary;
    System.out.println("Nowe wynagordzenie na system.");
    System.out.println("Idz do HR.");
    System.out.println("Wladza i tak wie.");
}
public void raiseSalary(Double raise) throws IllegalArgumentException, IllegalAccessException {
    if (raise < 0)
        throw new IllegalArgumentException("Sianko nie moze byc mneijsze niz 0");
    if (!(this.salary > 0))
        throw new IllegalAccessException("nie dostaniesz wyplaty bez pracy");
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
            this.age + " wiek i zwierz: " + this.pet +
            " i jego numer to: " + this.number;
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
                if (this.garage[index] > this.garage[jndex]) {
                    Car temp = this.garage[jndex];
                    this.garage[jndex] = this.garage[index];
                    this.garage[index] = temp;
                }
            }
        }
    } else {
        for (int index = 0; index < this.howManyCarsInGarage(); ++index) {
            for (int jndex = index + 1; jndex < this.howManyCarsInGarage(); ++jndex) {
                if (this.garage[index] < this.garage[jndex].) {
                    Car temp = this.garage[jndex];
                    this.garage[jndex] = this.garage[index];
                    this.garage[index] = temp;
                }
            }
        }
    }
}

public void installApp(Application app) {
    if (this.cash < app.getAmount()) {
        System.out.println("Nie masz tyle kasy na ta apke.");
        return;
    }
    this.cash -= app.getAmount();
    this.number.installAnApp(app);
}

@Override
public int compare(Human o1, Human o2) {
    if (o1 == null || o2 == null) throw new IllegalStateException("Czlek nie istnieje.");
    if (o1.age.equals(o2.age) && o1.name.equals(o2.name) &&
            o1.surname.equals(o2.surname) && o1.number.equals(o2.number) &&
            o1.garage.equals(o2.garage)) return 0;
    return 1;
}
@Override
public int compareTo(Human o2) {
    if (o2 == null) throw new IllegalStateException("Czlek nie istnieje.");
    if (this.age.equals(o2.age) && this.name.equals(o2.name) &&
            this.surname.equals(o2.surname) && this.number.equals(o2.number) &&
            this.garage.equals(o2.garage)) return 0;
    return 1;
}
}}