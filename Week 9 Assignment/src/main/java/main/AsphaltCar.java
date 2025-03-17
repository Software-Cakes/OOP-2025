package main;

public class AsphaltCar extends RallyCar {
    protected double downforce;

    /* Modifiable Parameter(s) */
    public AsphaltCar (String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    /* Operations */
    public double getDownforce() {
        return downforce;
    }
    @Override
    public double calculatePerformance() {
        return (horsepower * 0.873) + (downforce * 0.548);
    }
}
