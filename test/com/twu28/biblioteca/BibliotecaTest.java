package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.*;


public class BibliotecaTest {
    private Biblioteca biblioteca;
    private Output mockOutput;
    private Input mockInput;
    private LinkedList<Book> books;

    @Before
    public void setUp() throws Exception {
        mockOutput = mock(Output.class);
        mockInput = mock(Input.class);
        biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());
        when(mockInput.read()).thenReturn("0");
    }

    @Test(timeout = 1000)
    public void shouldWelcomeCustomer() throws Exception {
        biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());

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
        when(mockInput.read()).thenReturn("100").thenReturn("0");

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
        when(mockInput.read()).thenReturn("1").thenReturn("0");
        biblioteca.addBook(new Book("TDD", "Kent Beck", "001"));
        biblioteca.start();

        verify(mockOutput).print("001, TDD, Kent Beck");
    }

    @Test(timeout = 1000)
    public void shouldSayEnjoyingTheBook() throws Exception {
        when(mockInput.read()).thenReturn("2", "001").thenReturn("0");

        Book mockBook = mock(Book.class);
        when(mockBook.isAvailable()).thenReturn(true);

//        Biblioteca mockBiblioteca = mock(Biblioteca.class);
//        when(mockBiblioteca.isLoggedIn()).thenReturn(true);

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());
        biblioteca.addBook(new Book("TDD", "Kent Beck", "001"));
        biblioteca.start();

        verify(mockOutput).print("Thank You! Enjoy the book.");
    }

    @Test(timeout = 1000)
    public void shouldSaySorryForNotHavingTheBook() throws Exception {
        when(mockInput.read()).thenReturn("2", "003").thenReturn("0");

        Book mockBook = mock(Book.class);
        when(mockBook.isAvailable()).thenReturn(false);

//        Biblioteca mockBiblioteca = mock(Biblioteca.class);
//        when(mockBiblioteca.isLoggedIn()).thenReturn(true);

        Biblioteca biblioteca = new Biblioteca(mockOutput, mockInput, new LinkedList<Book>(), new LinkedList<Movie>());
        biblioteca.addBook(new Book("TDD", "Kent Beck", "001"));
        biblioteca.start();

        verify(mockOutput).print("Sorry we don't have that book yet.");
    }

    @Test(timeout = 1000)
    public void shouldNoticeWithPleaseTalkToLibrarian() throws Exception {
        when(mockInput.read()).thenReturn("3").thenReturn("0");

        biblioteca.start();

        verify(mockOutput).print("Please talk to librarian. Thank you!");
    }
}