package com.twu28.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void shouldDisplayMovieHasRating() {
        Movie movie = new Movie("Titanic", "Cameron", Rating.B);
        assertThat(movie.toString(), is("Titanic - Cameron - B"));
    }

    @Test
    public void shouldDisplayAMovieDoNotHaveRating() {
        Movie movie = new Movie("Titanic", "Cameron", Rating.NOTYET);
        assertThat(movie.toString(), is("Titanic - Cameron - N/A"));
    }
}
