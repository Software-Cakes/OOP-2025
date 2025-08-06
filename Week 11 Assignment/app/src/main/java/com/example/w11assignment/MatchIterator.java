package com.example.w11assignment;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MatchIterator implements Iterator<Match> {
    // matchIterator's constructor(s)
    private final List<Match> matches;
    private int currentIndex = 0;
    public MatchIterator(List<Match> matches) {
        this.matches = matches;
    }

    // methods
    @Override
    public boolean hasNext() {
        return currentIndex < matches.size();
    }
    @Override
    public Match next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more matches left in the list.");
        }
        return matches.get(currentIndex++);
    }
}
