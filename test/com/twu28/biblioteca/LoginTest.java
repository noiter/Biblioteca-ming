package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginTest {
    private Output mockOutput;
    private Input mockInput;

    @Before
    public void setUp() throws Exception {
        mockInput = mock(Input.class);
        mockOutput = mock(Output.class);
    }

    @Test
    public void shouldDisplayUserLibraryNumber() {
        when(mockInput.read()).thenReturn("3", "111-1112", "123456").thenReturn("0");

//        User mockUser = mock(User.class);
//        when(mockUser.verify("")).thenReturn(true);

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());
        biblioteca.start();

        verify(mockOutput).print("Thanks! Enjoy.");
    }

    @Test
    public void shouldDisplayLoginFailed() {
        when(mockInput.read()).thenReturn("3", "111-1112", "654321").thenReturn("0");

//        User mockUser = mock(User.class);
//        when(mockUser.verify("")).thenReturn(true);

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());
        biblioteca.start();

        verify(mockOutput).print("Please talk to librarian. Thank you!");
    }

    @Test
    public void shouldHintWhenReservingBook() {
        when(mockInput.read()).thenReturn("2").thenReturn("0");

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());
        biblioteca.start();

        verify(mockOutput).print("Sorry, but you need to login first!");
    }
}
