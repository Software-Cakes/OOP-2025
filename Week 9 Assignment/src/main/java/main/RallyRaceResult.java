package main;
import java.util.*;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new HashMap<>();

    public void recordRaceResult(String raceName, String location, Map<Driver, Integer> racePositions) {
        this.raceName = raceName;
        this.location = location;
        for (Map.Entry<Driver, Integer> entry : racePositions.entrySet()) {
            Driver driver = entry.getKey();
            int position = entry.getValue();
            int points = calculatePoints(position);
            results.put(driver, points);
            driver.addPoints(points);
        }
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults() {
        return new ArrayList<>(results.keySet());
    }

    private int calculatePoints(int position) {
        switch (position) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            default: return 0;
        }
    }
}
