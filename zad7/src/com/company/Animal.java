package com.company;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Animal {

    private SPECIES species;
    private String name;
    private boolean isAlive;
    private BigDecimal weight;
    private File picture;

    public Animal() {
        this.species = SPECIES.NONE;
        this.name = "";
        this.isAlive = false;
        this.weight = new BigDecimal("0.0");
        this.picture = null;
    }

    public Animal(String name, SPECIES species, File picture) {
        this.name = name;
        this.species = species;
        try {
            this.weight = this.weightOfSpecies(species);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.weight = new BigDecimal(1); // default
        }
        this.picture = picture;
        this.isAlive = true;
    }

    public Animal(String name, SPECIES species, boolean isAlive, File picture) {
        this.name = name;
        this.species = species;
        this.isAlive = isAlive;
        try {
            this.weight = this.weightOfSpecies(species);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.weight = new BigDecimal(1); // default
        }
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SPECIES getSpecies() {
        return species;
    }

    public void setSpecies(SPECIES species) {
        this.species = species;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public void feed() throws IllegalStateException {
        if (!this.isAlive())
            throw new IllegalStateException("Zwierze juz umarlo.kup nowe.");
        this.weight = this.weight.add(new BigDecimal(1));
        System.out.println("Waga teraz rosnie: " + this.weight);
    }

    public void walk(Double distance) {
        while (distance > 0) {
            System.out.println("Odleglosc do przebycia: " + distance);
            --distance;
            this.weight = this.weight.subtract(new BigDecimal(1));
            this.weight = this.weight.setScale(2, RoundingMode.HALF_UP);
            //if (this.isHungry()) while(this.isHungry()) this.feed();
            if (!this.currentState()) return;
        }
        System.out.println("Waga jest tracona teraz: " + this.weight);
    }

    public boolean isHungry() {
        if (this.weight.doubleValue() <= 5.0 && this.currentState()) {
            System.out.println("[" + this.name + "]: Umieram z glodu..");
            return true;
        }
        System.out.println("[" + this.name + "]: Nie jestem glodny..");
        return false;
    }

    public boolean currentState() {
        if (this.weight.doubleValue() <= 0) {
            System.out.println(this.name + " umrzyk.");
            this.isAlive = false;
            return false;
        }
        System.out.println(this.name + " zyjacy.");
        return true;
    }

    private BigDecimal weightOfSpecies(SPECIES specie) throws IllegalArgumentException {
        switch (specie) {
            case CAT:
                return new BigDecimal(4);
            case DOG:
                return new BigDecimal(10);
            case RAT:
            case HAMSTER:
                return new BigDecimal(1);
            case FISH:
                return BigDecimal.valueOf(0.3);
            case MOUSE:
                return BigDecimal.valueOf(0.7);
            case PARROT:
                return new BigDecimal(2);
        }

        throw new IllegalArgumentException("zly argument..");
    }

    @Override
    public boolean equals(Object obj) {
        Animal animal = (Animal) obj;

        return this.isAlive == animal.isAlive &&
                this.weight.equals(animal.weight) &&
                this.species == animal.species &&
                this.name.equals(animal.name) &&
                this.picture == animal.picture;
    }

    @Override
    public String toString() {
        return this.name + " wazy: " + this.weight + " i jest to " + this.species;
    }
}