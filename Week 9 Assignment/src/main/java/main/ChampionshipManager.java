package main;
import java.util.*;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void recordRaceResult(RallyRaceResult result) {
        races.add(result);
    }

    public List<Driver> getChampionshipStandings() {
        return drivers.stream()
                .sorted((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()))
                .toList();
    }

    public Driver getLeadingDriver() {
        return getChampionshipStandings().isEmpty() ? null : getChampionshipStandings().get(0);
    }

    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    public List<RallyRaceResult> getRaceResults() {
        return races;
    }
}