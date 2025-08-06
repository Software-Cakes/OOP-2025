package com.example.w11assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T> {
    // repository's constructors
    private List<T> items;
    public Repository() {
        this.items = new ArrayList<>();
    }

    // methods
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("ERROR: Unable to append item to repository.");
        }
        items.add(item);
    }
    public List<T> filter(Predicate<T> condition) {
        if (condition == null) {
            throw new IllegalArgumentException("ERROR: Filter condition cannot be null.");
        }
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}