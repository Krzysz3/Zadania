package com.company;
import devices.Car;
import devices.Phone;

import java.io.File;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("822", "Maluch", 1.0, new BigDecimal("10000.00"));
        Car car2 = new Car("822", "Maluch", 1.0, new BigDecimal("10000.00"));

        System.out.println(car1.equals(car2));
        System.out.println(car1);
        System.out.println(car2);

        Phone phone1 = new Phone(12345678, "ORANGE", 48);
        Phone phone2 = new Phone(12345678, "ORANGE", 48);

        System.out.println(phone1.equals(phone2));
        System.out.println(phone1);
        System.out.println(phone2);

        Human human1 = new Human("Janek", "MAO", 20.0, phone1);
        Human human2 = new Human("Janek", "MAO", 20.0, phone1);

        System.out.println(human1.equals(human2));
        System.out.println(human1);
        System.out.println(human2);

        Animal animal1 = new Animal("Doggy", SPECIES.DOG, new File(""));
        Animal animal2 = new Animal("Doggy", SPECIES.DOG, new File(""));

        System.out.println(animal1.equals(animal2));
        System.out.println(animal1);
        System.out.println(animal2);

    }
}
