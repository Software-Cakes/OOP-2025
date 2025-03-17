package main;

public class Driver {
    protected String name; 
    protected String country;
    protected int points;
    protected RallyCar car;
    
    /* Modifiable Parameter(s) */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.points = 0;
        this.car = car;
    }

    /* Operations */
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCar(RallyCar car) {
        this.car = car;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public int getPoints() {
        return points;
    }
    public RallyCar getCar() {
        return car;
    }
    public void addPoints(int points) {
        this.points += points;
    }
}
