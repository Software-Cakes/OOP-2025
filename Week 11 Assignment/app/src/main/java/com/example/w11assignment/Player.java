package com.example.w11assignment;

public class Player implements SoccerEntity {
    // player's constructor(s)
    private String id;
    private String name;
    private String team;
    private String position;

    public Player (String id, String name, String team, String position) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.position = position;
    }

    // methods
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getPosition() { return position; }
}