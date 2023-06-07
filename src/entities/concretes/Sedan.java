package entities.concretes;

import entities.abstracts.Car;

public class Sedan extends Car {
    public Sedan(double baggageCapacity, double dailyRentalFee, String color, String typeName) {
        super(baggageCapacity, dailyRentalFee, color, typeName);
    }
}
