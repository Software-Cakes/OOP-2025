package main;

public abstract class RallyCar {
    protected String make; 
    protected String model; 
    protected int horsepower;

    /* Modifiable Parameter(s) */
    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model; 
        this.horsepower = horsepower;
    }

    /* Operations */
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getHorsepower() {
        return horsepower;
    }
    public abstract double calculatePerformance();
}