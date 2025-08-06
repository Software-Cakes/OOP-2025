package com.example.w11assignment;

public class Team implements SoccerEntity {
    // team's constructor(s)
    private String id;
    private String name;
    private String country;
    private String league;

    public Team(String id, String name, String country, String league) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.league = league;
    }

    // methods
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getLeague() { return league; }
}
