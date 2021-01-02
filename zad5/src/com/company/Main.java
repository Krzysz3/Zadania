package com.company;
import java.io.File;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        Human Janek = new Human("Janek", "Anasz", 23.0,
                new Phone(123456789, "Orange"),
                new Animal("Julek", SPECIES.DOG, new File("")));
        System.out.println(Janek.getName());
        System.out.println(Janek.getSurname());
        System.out.println(Janek.getAge());
        System.out.println(Janek.getNumber().getNumber());
        System.out.println();
        System.out.println(Janek.getPet().getName());
        try {
            Janek.getPet().feed();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        Janek.getPet().walk(5.0);
        System.out.println(Janek.getPet().getWeight());
        try {
            Janek.getPet().feed();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        Janek.getPet().walk(5.0);
        System.out.println(Janek.getPet().getWeight());
        try {
            Janek.getPet().feed();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        Janek.setSalary(3000.0);

        System.out.println(Janek.getSalary());
        try {
            Janek.raiseSalary(500.0);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Janek.getSalary());

        Car porsche = new Car("303", "Maluch", 1.0, new BigDecimal("1000.0"));
        Janek.setCar(porsche);
        System.out.println("1"); // flag for checking if each exception was caught.


    }
}
