package entities.concretes;

import entities.abstracts.Car;

public class Suv extends Car {
    private int age;
    private static final int AGECONSTANT = 200;
    public Suv(double baggageCapacity, double dailyRentalFee, String color, String typeName, int age) {
        super(baggageCapacity, dailyRentalFee, color, typeName);
        this.age=age;

    }
    @Override
    public double getMontlyRentalFee(){
        return getDailyRentalFee()*30;
    }
    @Override
    public double getDailyRentalFee(){
       return super.getDailyRentalFee() - (AGECONSTANT * this.age/30);

    }
}


