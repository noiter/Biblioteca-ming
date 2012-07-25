package com.twu28.biblioteca;

public class Movie {
    private String name;
    private String director;
    private Rating rating;

    public Movie(String name, String director, Rating rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        if(this.rating == Rating.NOTYET) {
            return name + " - " + director + " - N/A";
        } else {
            return name + " - " + director + " - " + rating;
        }
    }
}
