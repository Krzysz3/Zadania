package com.company;
import java.io.File;
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
        Car maluch = new Car("303", "Maluch", 5.0);
        Janek.setCar(maluch);
        System.out.println("1");

        System.out.println(Janek.getCar().getProducer() + " " + Janek.getCar().getModel());

        Janek.setSalary(3000.0);

        System.out.println(Janek.getSalary());
        Janek.raiseSalary(500.0);
        System.out.println(Janek.getSalary());
    }
}
