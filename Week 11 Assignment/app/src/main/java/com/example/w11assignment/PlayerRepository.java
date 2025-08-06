package com.example.w11assignment;
import java.util.List;

public class PlayerRepository extends Repository<Player> {
    // playerRepository's constructor(s)
    public PlayerRepository() { super(); }

    // methods
    public List<Player> filterByTeam(String team) {
        if (team == null || team.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Team name cannot be null or empty.");
        }
        return filter(player -> team.equals(player.getTeam()));
    }
    public List<Player> filterByPosition(String position) {
        if (position == null || position.isEmpty()) {
            throw new IllegalArgumentException(("ERROR: Position cannot be null or empty."));
        }
        return filter(player -> position.equals(player.getPosition()));
    }
}