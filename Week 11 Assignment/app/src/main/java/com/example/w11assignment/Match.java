package com.example.w11assignment;

public class Match implements SoccerEntity {
    // match's constructor(s)
    private String id;
    private String name;
    private String homeTeam;
    private String awayTeam;
    private String score;

    public Match(String id, String name, String homeTeam, String awayTeam, String score) {
        this.id = id;
        this.name = name;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    // methods
    public String getId() { return id; }
    public String getName() { return name; }
    public String getHomeTeam() { return homeTeam; }
    public String getAwayTeam() { return awayTeam; }
    public String getScore() { return score; }
}
