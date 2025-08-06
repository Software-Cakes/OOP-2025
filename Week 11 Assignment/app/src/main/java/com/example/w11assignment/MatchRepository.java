package com.example.w11assignment;
import java.util.List;

public class MatchRepository extends Repository<Match> {
    // matchRepository's constructor(s)
    public MatchRepository() { super(); }

    // methods
    public List<Match> filterByHomeTeam(String homeTeam) {
        if (homeTeam == null || homeTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: HomeTeam name cannot be null or empty.");
        }
        return filter(match -> homeTeam.equals(match.getHomeTeam()));
    }
    public List<Match> filterByAwayTeam(String awayTeam) {
        if (awayTeam == null || awayTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: AwayTeam name cannot be null or empty.");
        }
        return filter(match -> awayTeam.equals(match.getAwayTeam()));
    }
}