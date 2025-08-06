package com.example.w11assignment;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PlayerIterator implements Iterator<Player> {
    // playerIterator's constructor(s)
    private final List<Player> players;
    private int currentIndex = 0;
    public PlayerIterator(List<Player> players) {
        this.players = players;
    }

    // methods
    @Override
    public boolean hasNext() {
        return currentIndex < players.size();
    }
    @Override
    public Player next() {
        if (!hasNext()) {
            throw new NoSuchElementException("ERROR: No more players left in the list.");
        }
        return players.get(currentIndex++);
    }
}