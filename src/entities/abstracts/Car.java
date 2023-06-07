package entities.abstracts;

public abstract class Car {
    private double baggageCapacity;
    private double dailyRentalFee;
    private String color;
    private String typeName;

    public Car(double baggageCapacity, double dailyRentalFee, String color, String typeName) {
        this.baggageCapacity = baggageCapacity;
        this.dailyRentalFee = dailyRentalFee;
        this.color = color;
        this.typeName = typeName;
    }

    public double getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(double baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public double getDailyRentalFee() {
        return dailyRentalFee;
    }

    public void setDailyRentalFee(double dailyRentalFee) {
        this.dailyRentalFee = dailyRentalFee;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getMontlyRentalFee(){
        return this.dailyRentalFee * 30;
    }

}
