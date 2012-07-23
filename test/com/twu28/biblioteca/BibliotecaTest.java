package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaTest {
    private Biblioteca biblioteca;
    private Output mockOutput;
    private Input mockInput;

    @Before
    public void setUp() throws Exception {
        mockOutput = mock(Output.class);
        mockInput = mock(Input.class);
        biblioteca = new Biblioteca(mockOutput, mockInput);
        when(mockInput.read()).thenReturn(0);
    }

    @Test(timeout = 1000)
    public void shouldWelcomeCustomer() throws Exception {

        biblioteca.start();

        verify(mockOutput).print("Welcome User.");
    }

    @Test(timeout = 1000)
    public void shouldSayMenuOptions() throws Exception {
        biblioteca.start();

        verify(mockOutput).print("0. Exit");
    }

    @Test(timeout = 1000)
    public void shouldExitApplicationOnSelecting0() throws Exception {

        biblioteca.start();

        verify(mockOutput).print("Bye!!!");
    }

    @Test(timeout = 1000)
    public void shouldAskToSelectValidOption() throws Exception {
        when(mockInput.read()).thenReturn(100).thenReturn(0);

        biblioteca.start();

        verify(mockOutput).print("Select a valid option");
    }

    @Test(timeout = 1000)
    public void shouldDisplayMenuOfViewingAllBooks() throws Exception {
        biblioteca.start();

        verify(mockOutput).print("1. View All Books");
    }

    @Test(timeout = 1000)
    public void canSelectMenuToViewAllBooks() throws Exception {
        when(mockInput.read()).thenReturn(1).thenReturn(0);

        biblioteca.start();

        verify(mockOutput).print("Gone With the Wind");
    }

    @Test(timeout = 1000)
    public void shouldSayEnjoyingTheBook() throws Exception {
        when(mockInput.read()).thenReturn(2, 1).thenReturn(0);

        Books mockBook = mock(Books.class);
        when(mockBook.isAvailable()).thenReturn(true);

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput);
        biblioteca.addBooks(mockBook);
        biblioteca.start();

        verify(mockOutput).print("Thank You! Enjoy the book.");
    }

    @Test(timeout = 1000)
    public void shouldSaySorryForNotHavingTheBook() throws Exception {
        when(mockInput.read()).thenReturn(2, 2).thenReturn(0);

        biblioteca.start();

        verify(mockOutput).print("Sorry we don't have that book yet.");
    }

    @Test(timeout = 1000)
    public void shouldNoticeWithPleaseTalkToLibrarian() throws Exception {
        when(mockInput.read()).thenReturn(3, 0);

        biblioteca.start();

        verify(mockOutput).print("Please talk to librarian. Thank you!");
    }

    @Test(timeout = 1000)
    public void shouldDisplayMenuOfViewingAllMovies() throws Exception {

        biblioteca.start();

        verify(mockOutput).print("4. View ALl Movies");
    }

    @Test(timeout = 1000)
    public void canViewTheMovieSholayRamesh() throws Exception {
        when(mockInput.read()).thenReturn(4).thenReturn(0);

        biblioteca.start();
        verify(mockOutput).print("SholayRamesh Sippy N/A");
    }

    @Test
    public void canViewTheMovieTitanic() throws Exception {
        when(mockInput.read()).thenReturn(4).thenReturn(0);

        biblioteca.start();
        verify(mockOutput).print("Titanic Cameron B");
    }
}
