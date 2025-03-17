package main;

public class GravelCar extends RallyCar {
    protected double suspensionTravel;

    /* Modifiable Parameter(s) */
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }
    
    /* Operations */
    public double getSuspensionTravel() {
        return suspensionTravel;
    }
    @Override
    public double calculatePerformance() {
        return horsepower * 0.75 + suspensionTravel * 11.23;
    }
}
