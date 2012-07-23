package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/20/12
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movies {
    private String name;
    private String director;
    private Rating rating;

    public Movies(String name, String director, Rating rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public Rating getRating() {
        return rating;
    }
}
