package org.example.repository;

public class Car extends Vehicle {

    private int numberOfPassengers;


    public Car(String licensePlate, int numberOfPassengers) {
        super(licensePlate);
        this.numberOfPassengers = numberOfPassengers;
    };

    public Car(String licensePlate) {
        super(licensePlate);
    };

    public Car() {
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
