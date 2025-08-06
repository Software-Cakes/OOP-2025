package com.example.w11assignment;
import java.util.List;

public class TeamRepository extends Repository<Team> {
    // teamRepository's constructor(s)
    public TeamRepository() { super(); }

    // methods
    public List<Team> filterByLeague(String league) {
        if (league == null || league.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: League name cannot be null or empty.");
        }
        return filter(team -> league.equals(team.getLeague()));
    }
    public List<Team> filterByCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Country name cannot be null or empty.");
        }
        return filter(team -> country.equals(team.getCountry()));
    }
}