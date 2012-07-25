package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieTest {

    private LinkedList<Movie> movies = new LinkedList<Movie>();
    private Output mockOutput;
    private Input mockInput;

    @Before
    public void setUp() throws Exception {
        mockOutput = mock(Output.class);
        mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn("4").thenReturn("0");
    }

    @Test(timeout = 1000)
    public void shouldDisplayMovieHasRating() {

        Movie movie = new Movie("Titanic", "Cameron", Rating.B);
        movies.add(movie);

        execute();

        verify(mockOutput).print("Titanic - Cameron - B");
    }

    @Test
    public void shouldDisplayAMovieDoNotHaveRating() {

        Movie movie = new Movie("Titanic", "Cameron", Rating.NOTYET);
        movies.add(movie);

        execute();

        verify(mockOutput).print("Titanic - Cameron - N/A");
    }

    private void execute() {
        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), movies);
        biblioteca.start();
    }
}
