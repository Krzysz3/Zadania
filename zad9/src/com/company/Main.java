package com.company;

import device.Car;
import device.Phone;

import java.io.File;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("303", "Maluch", 1.0, new BigDecimal("10000.00"));
        Car car2 = new Car("303", "Maluch", 1.0, new BigDecimal("10000.00"));

        System.out.println(car1.equals(car2));
        System.out.println(car1);
        System.out.println(car2);

        Phone phone1 = new Phone(12345678, "ORANGE", 48);
        Phone phone2 = new Phone(12345678, "ORANGE", 48);

        System.out.println(phone1.equals(phone2));
        System.out.println(phone1);
        System.out.println(phone2);

        Human human1 = new Human("Jan", "Mal", 23.0, phone1);
        Human human2 = new Human("Jan", "Mal", 23.0, phone1);

        System.out.println(human1.equals(human2));
        System.out.println(human1);
        System.out.println(human2);

        Animal animal1 = new FarmAnimal("Doggy", SPECIES.DOG, new File(""));
        Animal animal2 = new Pet("pies", SPECIES.DOG, new File(""));

        System.out.println(animal1.equals(animal2));
        System.out.println(animal1);
        System.out.println(animal2);

        System.out.println(car1.currentMode());
        car1.turnOn();
        System.out.println(car1.currentMode());
        car1.turnOff();
        System.out.println(car1.currentMode());

        System.out.println(car1);
        System.out.println(phone1);
        human1.setPet(animal1);
        human2.addMoney(4.0);

        System.out.println(human1.getPet());
        System.out.println("Transaction..");

        if(human1.getPet().sell(human1, human2, new BigDecimal(1.50))) {
            System.out.println(human1.getPet());
            System.out.println(human2.getPet());
        } else {
            System.out.println("Shit happened.");
        }

        System.out.println(human1.getNumber());
        System.out.println("Transaction..");
        if(human1.getNumber().sell(human1, human2, new BigDecimal(1.50))) {
            System.out.println(human1.getNumber());
            System.out.println(human2.getNumber());
        } else {
            System.out.println("Shit happened.");
        }
        animal1.feed();
        animal1.feed(1.5);
    }
}
