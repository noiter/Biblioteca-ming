package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;

public class Biblioteca {
    private final Output output;
    private final Input input;
    private LinkedList<Book> bookList;
    private LinkedList<Movie> movieList;

    public Biblioteca(Output output, Input input, LinkedList<Book> books, LinkedList<Movie> movies) {
        this.output = output;
        this.input = input;
        this.bookList = books;
        this.movieList = movies;
    }

    public void addBooks(Book book) {
        bookList.add(book);
    }

    public void start() {
        welcomeUser();
        while (true) {
            if (promptLoop()) break;
        }
    }

    private boolean promptLoop() {
        printMenu();
        int input = Integer.parseInt(this.input.read());
        switch (input) {
            case 0: {
                output.print("Bye!!!");
                return true;
            }
            case 1: {
                printBooks();
                return false;
            }
            case 2: {
                selectBook();
                return false;
            }
            case 3: {
                output.print("Please talk to librarian. Thank you!");
                return false;
            }
            case 4: {
                printMovies();
                return false;
            }
            default:
                output.print("Select a valid option");
                return false;
        }
    }

    private void printMenu() {
        output.print("0. Exit");
        output.print("1. View All Books");
        output.print("2. Reserve Book");
        output.print("3. Check Library Number");
        output.print("4. View ALl Movies");
    }

    private void welcomeUser() {
        output.print("Welcome User.");
    }

    private void printBooks() {
        for (Book book : bookList) {
            output.print(book.toString());
        }
    }

    private void printMovies() {
        output.print("DISPLAY: MoviesName - Director - Rating");

        for (Movie movie : movieList) {
            this.output.print(movie.toString());
        }
    }

    private void selectBook() {
        String isbn = this.input.read();

        if (isAvailable(isbn)) {
            Book book = findByIsbn(isbn);
            book.setAvailable(false);
            output.print("Thank You! Enjoy the book.");
        } else {
            output.print("Sorry we don't have that book yet.");
        }
    }

    private boolean isAvailable(String isbn) {
        Book book = findByIsbn(isbn);
        if (book == null) {
            return false;
        }
        if (book.isAvailable()) {
            return true;
        }
        return false;
    }

    private Book findByIsbn(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Book> books = new LinkedList<Book>();
        books.add(new Book("TDD", "Kent Beck", "001"));
        books.add(new Book("Head First Java", "Kathy Sierra", "002"));

        LinkedList<Movie> movies = new LinkedList<Movie>();
        movies.add(new Movie("SholayRamesh", "Sippy", Rating.NOTYET));
        movies.add(new Movie("Titanic", "Cameron", Rating.B));

        new Biblioteca(new Output(), new Input(), books, movies).start();
    }
}
