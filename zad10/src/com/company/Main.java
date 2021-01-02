package com.company;

import devices.Benzin;
import devices.Car;
import devices.Phone;

import java.io.File;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Benzin("303", "Maluch", 1.0, new BigDecimal("10000.00"));
        System.out.println(car1);

        Phone phone1 = new Phone(12345678, "ORANGE", 48);
        System.out.println(phone1);


        Human human1 = new Human("Janek", "Mak", 20.0, phone1);
        Human human2 = new Human("Janek", "Mak", 20.0, phone1);
        System.out.println(human1.equals(human2));
        System.out.println(human1);
        System.out.println(human2);

        Animal animal1 = new FarmAnimal("Doggy", SPECIES.DOG, new File(""));
        animal1.feed();
        animal1.feed(1.5);
    }
}
