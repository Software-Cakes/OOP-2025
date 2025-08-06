package com.example.w11assignment;
import java.util.ArrayList;
import java.util.List;

public class DataProvider<T> {
    public List<T> getData(List<T> data) {
        return new ArrayList<>(data);
    }

    public static List<Team> createTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("1", "FC Barcelona", "Spain", "La Liga"));
        teams.add(new Team("2", "Manchester United", "England", "Premier League"));
        teams.add(new Team("3", "Bayern Munich", "Germany", "Bundesliga"));
        teams.add(new Team("4", "Juventus", "Italy", "Serie A"));
        teams.add(new Team("5", "Paris Saint-Germain", "France", "Ligue 1"));
        teams.add(new Team("6", "Ajax Amsterdam", "Netherlands", "Eredivisie"));
        teams.add(new Team("7", "River Plate", "Argentina", "Primera División"));
        teams.add(new Team("8", "Flamengo", "Brazil", "Brasileirão"));
        return teams;
    }

    public static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("1", "Lionel Messi", "FC Barcelona", "Forward"));
        players.add(new Player("2", "Cristiano Ronaldo", "Juventus", "Forward"));
        players.add(new Player("3", "Robert Lewandowski", "Bayern Munich", "Forward"));
        players.add(new Player("4", "Kevin De Bruyne", "Manchester City", "Midfielder"));
        players.add(new Player("5", "Virgil van Dijk", "Liverpool", "Defender"));
        players.add(new Player("6", "Manuel Neuer", "Bayern Munich", "Goalkeeper"));
        players.add(new Player("7", "Kylian Mbappé", "Paris Saint-Germain", "Forward"));
        players.add(new Player("8", "Erling Haaland", "Borussia Dortmund", "Forward"));
        return players;
    }

    public static List<Match> createMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("1", "El Clásico", "FC Barcelona", "Real Madrid", "2-1"));
        matches.add(new Match("2", "Manchester Derby", "Manchester United", "Manchester City", "1-2"));
        matches.add(new Match("3", "German Classic", "Bayern Munich", "Borussia Dortmund", "4-2"));
        matches.add(new Match("4", "Derby d'Italia", "Juventus", "Inter Milan", "1-1"));
        matches.add(new Match("5", "French Classic", "Paris Saint-Germain", "Lyon", "3-0"));
        return matches;
    }
}