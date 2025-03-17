package main;
import java.util.*;

public class RallyChampionship {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        GravelCar gravelCar1 = new GravelCar("Toyota", "Yaris WRC", 380, 12.5);
        GravelCar gravelCar2 = new GravelCar("Hyundai", "i20 WRC", 370, 13.0);
        AsphaltCar asphaltCar1 = new AsphaltCar("Ford", "Puma Rally1", 390, 240.0);
        AsphaltCar asphaltCar2 = new AsphaltCar("M-Sport", "Fiesta WRC", 375, 225.0);

        Driver ogier = new Driver("Sébastien Ogier", "France", gravelCar1);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", gravelCar2);
        Driver tanak = new Driver("Ott Tänak", "Estonia", asphaltCar1);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar2);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        Map<Driver, Integer> finlandPositions = Map.of(
            ogier, 1, tanak, 2, rovanpera, 3, neuville, 4
        );
        RallyRaceResult finlandRally = new RallyRaceResult();
        finlandRally.recordRaceResult("Rally Finland", "Jyväskylä", finlandPositions);
        manager.recordRaceResult(finlandRally);

        rovanpera.setCar(asphaltCar1);
        tanak.setCar(gravelCar2);

        Map<Driver, Integer> monteCarloPositions = Map.of(
            rovanpera, 1, neuville, 2, ogier, 3, tanak, 4
        );
        RallyRaceResult monteCarloRally = new RallyRaceResult();
        monteCarloRally.recordRaceResult("Monte Carlo Rally", "Monaco", monteCarloPositions);
        manager.recordRaceResult(monteCarloRally);

        displayChampionshipStandings(manager);
        displayChampionshipLeader(manager);
        displayChampionshipStatistics(manager);
        displayRaceResults(manager);
        displayCarPerformanceRatings();
    }

    private static void displayChampionshipStandings(ChampionshipManager manager) {
        int position = 1;
        for (Driver driver : manager.getChampionshipStandings()) {
            System.out.println(position + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            position++;
        }
        System.out.println();
    }

    private static void displayChampionshipLeader(ChampionshipManager manager) {
        Driver leader = manager.getLeadingDriver();
        System.out.println("===== CHAMPIONSHIP LEADER =====");
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        } else {
            System.out.println("No leader found");
        }
        System.out.println();
    }

    private static void displayChampionshipStatistics(ChampionshipManager manager) {
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getChampionshipStandings().size());
        System.out.println("Total Races: " + manager.getRaceResults().size());
        System.out.printf("Average Points Per Driver: %.2f%n", ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getChampionshipStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getChampionshipStandings()));
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());
        System.out.println();
    }

    private static void displayRaceResults(ChampionshipManager manager) {
        System.out.println("===== RACE RESULTS =====");
        for (RallyRaceResult raceResult : manager.getRaceResults()) {
            System.out.println("Race: " + raceResult.getRaceName() + " (" + raceResult.getLocation() + ")");
            raceResult.getResults().stream()
                    .sorted(Comparator.comparingInt(raceResult::getDriverPoints).reversed())
                    .forEach(driver -> System.out.println("Position " + getPositionFromPoints(raceResult.getDriverPoints(driver)) + ": " + driver.getName() + " - " + raceResult.getDriverPoints(driver) + " points"));
            System.out.println();
        }
    }

    private static void displayCarPerformanceRatings() {
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.printf("Gravel Car Performance: %.1f%n", new GravelCar("Hyundai", "i20 WRC", 370, 13.0).calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f%n", new AsphaltCar("Ford", "Puma Rally1", 390, 240.0).calculatePerformance());
    }

    private static int getPositionFromPoints(int points) {
        return switch (points) {
            case 25 -> 1;
            case 18 -> 2;
            case 15 -> 3;
            case 12 -> 4;
            default -> 5;
        };
    }
}