package com.twu28.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BibliotecaTest {
    @Test(timeout = 1000)
    public void shouldWelcomeCustomer() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("Welcome User.");
    }

    @Test(timeout = 1000)
    public void shouldSayMenuOptions() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("0. Exit");
    }

    @Test(timeout = 1000)
    public void shouldExitApplicationOnSelecting0() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("Bye!!!");
    }

    @Test(timeout = 1000)
    public void shouldAskToSelectValidOption() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(100).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("Select a valid option");
    }

    @Test(timeout = 1000)
    public void shouldDisplayMenuOfViewingAllBooks() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("1. View All Books.");
    }

    @Test(timeout = 1000)
    public void canSelectMenuToViewAllBooks() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(1).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("Gone With the Wind");
    }

    @Test(timeout = 1000)
    public void shouldSayEnjoyingTheBook() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(2, 1).thenReturn(0);

        Books mockBook = mock(Books.class);
        when(mockBook.isAvailable()).thenReturn(true);

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput);
        biblioteca.addBooks(mockBook);
        biblioteca.start();

        verify(mockOutput).print("Thank You! Enjoy the book.");
    }


    @Test(timeout = 1000)
    public void shouldSaySorryForNotHavingTheBook() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(2, 2).thenReturn(0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("Sorry we don't have that book yet.");
    }

    @Test(timeout = 1000)
    public void shouldNoticeWithPleaseTalkToLibrarian() {
        Output mockOutput = mock(Output.class);
        Input mockInput = mock(Input.class);
        when(mockInput.read()).thenReturn(3, 0);

        new Biblioteca(mockOutput, mockInput).start();

        verify(mockOutput).print("Please talk to librarian. Thank you!");
    }

}
