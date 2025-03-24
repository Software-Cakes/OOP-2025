package com.example.w10assignment;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String posterResource;

    public Movie(String title, String year, String genre, String posterResource) {
        this.title = title != null ? title : "Unknown Title";
        this.year = year != null ? year : "Unknown Year";
        this.genre = genre != null ? genre : "Unknown Genre";
        this.posterResource = posterResource != null ? posterResource : "default_poster";
    }

    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getGenre() { return genre; }
    public String getPosterResource() { return posterResource; }
}