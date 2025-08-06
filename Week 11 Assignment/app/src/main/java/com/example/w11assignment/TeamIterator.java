package com.example.w11assignment;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TeamIterator implements Iterator<Team> {
    // teamIterator's constructor(s)
    private final List<Team> teams;
    private int currentIndex = 0;
    public TeamIterator(List<Team> teams) {
        this.teams = teams;
    }

    // methods
    @Override
    public boolean hasNext() {
        return currentIndex < teams.size();
    }
    @Override
    public Team next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more teams left in the list.");
        }
        return teams.get(currentIndex++);
    }
}
